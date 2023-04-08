package com.example.EduAI.service;

import com.example.EduAI.dto.ResourceDto;
import com.example.EduAI.model.Resource;
import com.example.EduAI.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private GPTService gptService;

    public ResourceDto createResource(ResourceDto resourceDto) {
        // Add logic for creating a resource
        Resource resource = new Resource();
        resource.setName(resourceDto.getName());
        resource.setType(resourceDto.getType());
        resource.setUrl(resourceDto.getUrl());

        Resource savedResource = resourceRepository.save(resource);

        ResourceDto savedResourceDto = new ResourceDto();
        savedResourceDto.setId(savedResource.getId());
        savedResourceDto.setName(savedResource.getName());
        savedResourceDto.setType(savedResource.getType());
        savedResourceDto.setUrl(savedResource.getUrl());

        return savedResourceDto;
    }

    public ResourceDto updateResource(Long id, ResourceDto resourceDto) {
        // Add logic for updating a resource
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            Resource resource = optionalResource.get();
            resource.setName(resourceDto.getName());
            resource.setType(resourceDto.getType());
            resource.setUrl(resourceDto.getUrl());

            Resource updatedResource = resourceRepository.save(resource);

            ResourceDto updatedResourceDto = new ResourceDto();
            updatedResourceDto.setId(updatedResource.getId());
            updatedResourceDto.setName(updatedResource.getName());
            updatedResourceDto.setType(updatedResource.getType());
            updatedResourceDto.setUrl(updatedResource.getUrl());

            return updatedResourceDto;
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }

    public void deleteResource(Long id) {
        // Add logic for deleting a resource
        resourceRepository.deleteById(id);
    }

    public ResourceDto getResource(Long id) {
        // Add logic for retrieving a resource
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            Resource resource = optionalResource.get();

            ResourceDto resourceDto = new ResourceDto();
            resourceDto.setId(resource.getId());
            resourceDto.setName(resource.getName());
            resourceDto.setType(resource.getType());
            resourceDto.setUrl(resource.getUrl());

            return resourceDto;
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }

    public List<ResourceDto> getAllResources() {
        // Add logic for retrieving all resources
        List<Resource> resources = resourceRepository.findAll();

        return resources.stream()
                .map(resource -> {
                    ResourceDto resourceDto = new ResourceDto();
                    resourceDto.setId(resource.getId());
                    resourceDto.setName(resource.getName());
                    resourceDto.setType(resource.getType());
                    resourceDto.setUrl(resource.getUrl());
                    return resourceDto;
                })
                .collect(Collectors.toList());
    }

    public List<ResourceDto> generateAndSaveResources(String topicName) {
        List<ResourceDto> generatedResources = gptService.generateResourceSuggestions(topicName);

        // Convert the list of ResourceDto objects to a list of Resource objects
        List<Resource> resourcesToSave = generatedResources.stream()
                .map(resourceDto -> {
                    Resource resource = new Resource();
                    resource.setName(resourceDto.getName());
                    resource.setType(resourceDto.getType());
                    resource.setUrl(resourceDto.getUrl());
                    return resource;
                })
                .collect(Collectors.toList());

        // Save the resources to the database
        List<Resource> savedResources = resourceRepository.saveAll(resourcesToSave);

        // Convert the list of saved Resource objects back to a list of ResourceDto objects
        List<ResourceDto> savedResourceDtos = savedResources.stream()
                .map(savedResource -> {
                    ResourceDto resourceDto = new ResourceDto();
                    resourceDto.setId(savedResource.getId());
                    resourceDto.setName(savedResource.getName());
                    resourceDto.setType(savedResource.getType());
                    resourceDto.setUrl(savedResource.getUrl());
                    return resourceDto;
                })
                .collect(Collectors.toList());

        return savedResourceDtos;
    }


    // Add any additional methods or configurations required for ResourceService
}

