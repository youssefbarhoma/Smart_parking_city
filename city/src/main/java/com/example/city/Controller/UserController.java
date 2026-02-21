package com.example.city.Controller;

import com.example.city.Model.User;
import com.example.city.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationDTO userDto) {
        User createdUser = userService.registerUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserProfile(@PathVariable String email) {
        // In the future, we will get email from the SecurityContext (JWT Token)
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
}