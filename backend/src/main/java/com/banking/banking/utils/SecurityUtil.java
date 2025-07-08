package com.banking.banking.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    /**
     * Mevcut authenticated kullanıcıyı döner.
     *
     * @return UserDetails veya kullanıcı objesi, yoksa null.
     */
    public static Object getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof String && principal.equals("anonymousUser")) {
            return null;
        }

        return principal;
    }

    /**
     * Mevcut kullanıcı kullanıcı sınıfınız (örneğin com.banking.banking.model.User) ise döner.
     *
     * @param userClass User sınıfınızın Class objesi
     * @param <T>       User sınıfı tipi
     * @return Kullanıcı objesi veya null
     */
    public static <T> T getCurrentUserAs(Class<T> userClass) {
        Object principal = getCurrentUser();
        if (userClass.isInstance(principal)) {
            return userClass.cast(principal);
        }
        return null;
    }
}