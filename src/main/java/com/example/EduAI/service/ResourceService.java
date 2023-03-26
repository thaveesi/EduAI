package com.example.EduAI.service;

import com.example.EduAI.dto.ResourceDto;
import com.example.EduAI.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private GPTService gptService;

    public ResourceDto createResource(ResourceDto resourceDto) {
        // Add logic for creating a resource
    }

    public ResourceDto updateResource(Long id, ResourceDto resourceDto) {
        // Add logic for updating a resource
    }

    public void deleteResource(Long id) {
        // Add logic for deleting a resource
    }

    public ResourceDto getResource(Long id) {
        // Add logic for retrieving a resource
    }

    public List<ResourceDto> getAllResources() {
        // Add logic for retrieving all resources
    }

    public List<ResourceDto> generateAndSaveResources(String topicName) {
        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);
        // Add logic for saving the generated resources to the database
        // Return the list of saved ResourceDto objects
    }


    // Add any additional methods or configurations required for ResourceService
}

