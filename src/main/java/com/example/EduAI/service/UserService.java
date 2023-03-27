package com.example.EduAI.service;
import com.example.EduAI.dto.UserDto;
import com.example.EduAI.dto.UserRegistrationDto;
import com.example.EduAI.model.User;
import com.example.EduAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Add other necessary methods for user management

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto registerUser(UserRegistrationDto userRegistrationDto) {
        // Add logic for user registration
        User user = new User();
        // Populate user object from userRegistrationDto
        user.setUsername(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        // Save user to the database
        User savedUser = userRepository.save(user);

        // Convert savedUser to UserDto and return
        return convertToUserDto(savedUser);
    }

    public UserDto findByUsername(String username) {
        // Add logic for finding user by username
        User user = userRepository.findByUsername(username);

        // Convert user to UserDto and return
        return convertToUserDto(user);
    }

    // Add other necessary methods for user management

    private UserDto convertToUserDto(User user) {
        // Convert User to UserDto
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        // Do not set the password in the UserDto, as it should not be exposed
        return userDto;
    }


}







