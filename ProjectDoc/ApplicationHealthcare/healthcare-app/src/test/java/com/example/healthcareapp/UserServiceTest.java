package com.example.healthcareapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.healthcare.authentication.AuthController;
import com.example.healthcare.user.User;
import com.example.healthcare.user.UserRepository;
import com.example.healthcare.user.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user.getName(), user.getEmail(), user.getPassword());

        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
        assertEquals("johndoe@example.com", createdUser.getEmail());
        assertEquals("password", createdUser.getPassword());
    }

    @Test
    public void testAuthenticate() {
        User user = new User();
        user.setEmail("email@example.com");
        user.setPassword("password");

        when(userRepository.findByEmail("email@example.com")).thenReturn(Optional.of(user));

        boolean isAuthenticated = userService.authenticate("email@example.com", "password");

        assertTrue(isAuthenticated);
    }
}
