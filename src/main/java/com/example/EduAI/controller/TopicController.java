package com.example.EduAI.controller;

import com.example.EduAI.dto.TopicDto;
import com.example.EduAI.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<TopicDto> createTopic(@RequestBody TopicDto topicDto) {
        // Add logic for creating a topic
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> updateTopic(@PathVariable Long id, @RequestBody TopicDto topicDto) {
        // Add logic for updating a topic
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        // Add logic for deleting a topic
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopic(@PathVariable Long id) {
        // Add logic for retrieving a topic
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        // Add logic for retrieving all topics
    }
}

