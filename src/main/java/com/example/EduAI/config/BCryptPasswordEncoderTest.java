package com.example.EduAI.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String plainTextPassword = "eduai"; // Replace with your actual password
        String hashedPassword = passwordEncoder.encode(plainTextPassword);
        System.out.println("Hashed password: " + hashedPassword);
    }
}
