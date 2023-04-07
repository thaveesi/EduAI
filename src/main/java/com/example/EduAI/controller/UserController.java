package com.example.EduAI.controller;
import com.example.EduAI.dto.UserDto;
import com.example.EduAI.dto.UserRegistrationDto;
import com.example.EduAI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        return userService.registerUser(userRegistrationDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
        UserDto foundUser = userService.findByUsername(username);
        return ResponseEntity.ok(foundUser);
    }

    // Add other necessary endpoints for user management
}