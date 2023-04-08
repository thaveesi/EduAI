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
        TopicDto createdTopic = topicService.createTopic(topicDto);
        return ResponseEntity.ok(createdTopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> updateTopic(@PathVariable Long id, @RequestBody TopicDto topicDto) {
        // Add logic for updating a topic
        TopicDto updatedTopic = topicService.updateTopic(id, topicDto);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        // Add logic for deleting a topic
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopic(@PathVariable Long id) {
        // Add logic for retrieving a topic
        TopicDto topic = topicService.getTopic(id);
        return ResponseEntity.ok(topic);
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        // Add logic for retrieving all topics
        List<TopicDto> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }
}

