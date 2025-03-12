package com.example.healthcare.authentication;

import org.springframework.web.bind.annotation.*;

import com.example.healthcare.user.User;
import com.example.healthcare.user.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticate(email, password);
        return isAuthenticated ? "Login successful" : "Invalid credentials";
    }

    @PostMapping("/signup")
    public User signup(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.createUser(name, email, password);
    }
}
