package com.example.EduAI.service;
import com.example.EduAI.dto.UserDto;
import com.example.EduAI.model.User;
import com.example.EduAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDto userDto) {
        // Add logic for user registration
        User user = new User();
        return user;
    }

    public User findByUsername(String username) {
        // Add logic for finding user by username

        User user = new User();
        return user;
    }

    // Add other necessary methods for user management
}
