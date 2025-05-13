package com.example.bookstore.services;

import com.example.bookstore.models.User;
import com.example.bookstore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(User user) {
        log.debug("Attempting to register new user with email: {}", user.getEmail());
        
        if (userRepository.existsByEmail(user.getEmail())) {
            log.warn("Registration failed - email already exists: {}", user.getEmail());
            throw new RuntimeException("Email already exists");
        }

        // Encode the password before saving
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        
        log.debug("Password encoded successfully for user: {}", user.getEmail());
        
        // Save the user
        User savedUser = userRepository.save(user);
        log.info("Successfully registered new user with email: {}", user.getEmail());
        
        return savedUser;
    }

    public Optional<User> findByEmail(String email) {
        log.debug("Looking up user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    public boolean verifyPassword(User user, String rawPassword) {
        log.debug("Verifying password for user: {}", user.getEmail());
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public User getByEmail(String email) {
        log.debug("Getting user by email: {}", email);
        return findByEmail(email)
                .orElseThrow(() -> {
                    log.error("User not found with email: {}", email);
                    return new RuntimeException("User not found");
                });
    }
} 