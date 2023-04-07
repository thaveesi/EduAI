package com.example.EduAI.controller;

import com.example.EduAI.dto.ResourceDto;
import com.example.EduAI.service.GPTService;
import com.example.EduAI.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
//
    @Autowired
    private GPTService gptService;
//
//    @PostMapping
//    public ResponseEntity<ResourceDto> createResource(@RequestBody ResourceDto resourceDto) {
//        // Add logic for creating a resource
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ResourceDto> updateResource(@PathVariable Long id, @RequestBody ResourceDto resourceDto) {
//        // Add logic for updating a resource
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
//        // Add logic for deleting a resource
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ResourceDto> getResource(@PathVariable Long id) {
//        // Add logic for retrieving a resource
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ResourceDto>> getAllResources() {
//        // Add logic for retrieving all resources
//    }

    @PostMapping("/generate")
    public ResponseEntity<List<ResourceDto>> generateResources(@RequestBody String topicName) {
        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
        return ResponseEntity.ok(generatedResources);
    }
}

