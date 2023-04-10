package com.example.EduAI.controller;

import com.example.EduAI.dto.ResourceDto;
import com.example.EduAI.service.GPTService;
import com.example.EduAI.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {



    @Autowired
    private ResourceService resourceService;

    @Autowired
    private GPTService gptService;

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @PostMapping
    public ResponseEntity<ResourceDto> createResource(@RequestBody ResourceDto resourceDto) {
        ResourceDto createdResource = resourceService.createResource(resourceDto);
        return ResponseEntity.ok(createdResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceDto> updateResource(@PathVariable Long id, @RequestBody ResourceDto resourceDto) {
        ResourceDto updatedResource = resourceService.updateResource(id, resourceDto);
        return ResponseEntity.ok(updatedResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<ResourceDto> getResource(@PathVariable Long id) {
        ResourceDto resourceDto = resourceService.getResource(id);
        return ResponseEntity.ok(resourceDto);
    }

    @GetMapping
    public ResponseEntity<List<ResourceDto>> getAllResources() {
        List<ResourceDto> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

//    @PostMapping("/generate")
//    public ResponseEntity<List<ResourceDto>> generateResources(@RequestBody String topicName) {
//        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
//        return ResponseEntity.ok(generatedResources);
//    }  //without logs

//    @PostMapping("/generate")
//    public ResponseEntity<List<ResourceDto>> generateResources(@RequestBody String topicName) {
//        logger.info("Received request to generate resources for topic: {}", topicName);
//        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
//        logger.info("Generated resources: {}", generatedResources);
//        return ResponseEntity.ok(generatedResources);
//    } //withlogs

//    @PostMapping("/generate")
//    public ResponseEntity<List<ResourceDto>> generateResources(@RequestBody Map<String, String> request) {
//        String topicName = request.get("topicName");
//        logger.info("Received request to generate resources for topic: {}", topicName);
//        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
//        logger.info("Generated resources: {}", generatedResources);
//        return ResponseEntity.ok(generatedResources);
//    } //taking in json input with logs

    @PostMapping("/generate")
    public ResponseEntity<List<ResourceDto>> generateResources(@RequestBody String topicName) {
        logger.info("Received request to generate resources for topic: {}", topicName);
        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
        logger.info("Generated resources: {}", generatedResources);
        return ResponseEntity.ok(generatedResources);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working!");
    }



}
