package com.banking.banking.service;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;


@Service
public class CookieService {
    @Value("${mode}")
    private String mode;

    public Cookie getCookie(String name, String value, Integer maxAge, boolean httpOnly) {
        if (name == null || value == null || maxAge == null)
            throw new IllegalArgumentException();

        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(httpOnly);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        cookie.setSecure(mode == "prod");

        return cookie;
    }

    public boolean addCookie(HttpServletResponse httpServletResponse, String name, String value, Integer maxAge, boolean httpOnly) {
        if (httpServletResponse == null)
            throw new IllegalArgumentException();

        Cookie cookie = getCookie(name, value, maxAge, httpOnly);
        httpServletResponse.addCookie(cookie);

        return true;
    }

    public Optional<Cookie> searchCookie(Stream<Cookie> cookieStream, String name) {
        return cookieStream.filter(cookie -> cookie.getName().equals(name)).findAny();
    }

}
