package com.banking.banking.filters;

import com.banking.banking.exceptions.custom.AuthenticationSideException;
import com.banking.banking.model.User;
import com.banking.banking.service.CookieService;
import com.banking.banking.service.JWTService;
import com.banking.banking.service.UserDetailsService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;
    private final CookieService cookieService;

    @Value("${jwt.security.secret_key_accessToken}")
    private String accessSecretKey;

    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    private static final List<String> EXCLUDED_PATHS = List.of(
            "/api/v1/users/login",
            "/api/v1/users/register"
    );

    public JWTRequestFilter(JWTService jwtService, UserDetailsService userDetailsService, CookieService cookieService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.cookieService = cookieService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            if (request.getCookies() != null) {
                Optional<Cookie> accessTokenCookie = cookieService.searchCookie(Arrays.stream(request.getCookies()), "accessToken");
                Cookie accessToken = accessTokenCookie.orElse(null);
                if (accessToken == null) {
                    throw new AuthenticationSideException("Authentication error");
                }

                String accessTokenGet = accessToken.getValue();
                String username = jwtService.extractMail(accessSecretKey, accessTokenGet);
                User user = (User) userDetailsService.loadUserByUsername(username);
                var tokenAuth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                tokenAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(tokenAuth);
            } else {
                throw new AuthenticationSideException("Authentication error");
            }
        }catch (AuthenticationException | JwtException authenticationException) {
            handleException(request, response, authenticationException);
            return;
        } catch (Exception exception) {
            handleException(request, response, exception);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return pathMatcher.match("/api/v1/users/login", path)
                || pathMatcher.match("/api/v1/users/register", path);
    }

    private void handleException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception) {
        handlerExceptionResolver.resolveException(httpServletRequest, httpServletResponse, null, exception);
    }
}
