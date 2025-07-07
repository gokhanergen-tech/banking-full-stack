package com.banking.banking.service;

import com.banking.banking.enums.RoleType;
import com.banking.banking.exceptions.custom.UserAlreadyExistException;
import com.banking.banking.model.Authority;
import com.banking.banking.model.User;
import com.banking.banking.repositories.AuthorityRepository;
import com.banking.banking.repositories.UserRepository;
import com.banking.banking.utils.CryptoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserDetailsService implements UserDetailsManager {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Value("${jwt.security.password_pepper}")
    private String pepper;

    public UserDetailsService(AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void createUser(UserDetails user) {
        if (userExists(user.getUsername())) {
            logger.warn("User creation failed: username '{}' is already taken.", user.getUsername());
            throw new UserAlreadyExistException();
        }

        String salt = CryptoUtils.generateSalt();

        User userCreation = (User) user;
        userCreation.setAuthorities(Set.of(authorityRepository.findByAuthority(RoleType.USER_ROLE)));
        userCreation.setPassword(passwordEncoder.encode(pepper + user.getPassword() + salt));
        userCreation.setSalt(salt);
        userRepository.save(userCreation);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userExists(username)) {
            throw new UsernameNotFoundException("There is not such a user");
        }
        UserDetails userDetails = userRepository.findByUsername(username);
        return userDetails;
    }
}
