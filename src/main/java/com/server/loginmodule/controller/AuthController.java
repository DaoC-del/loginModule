package com.server.loginmodule.controller;

import com.server.loginmodule.model.User;
import com.server.loginmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        boolean isValid = userService.validateUser(username, password);
        return isValid ? ResponseEntity.ok("User logged in successfully") :
                ResponseEntity.badRequest().body("Invalid credentials");
    }

    // 其他认证相关的方法...
}
