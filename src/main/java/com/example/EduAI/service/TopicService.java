package com.example.EduAI.service;

import com.example.EduAI.dto.TopicDto;
import com.example.EduAI.model.Topic;
import com.example.EduAI.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public TopicDto createTopic(TopicDto topicDto) {
        // Add logic for creating a topic
        Topic topic = new Topic();
        topic.setName(topicDto.getName());

        Topic savedTopic = topicRepository.save(topic);

        TopicDto savedTopicDto = new TopicDto();
        savedTopicDto.setId(savedTopic.getId());
        savedTopicDto.setName(savedTopic.getName());

        return savedTopicDto;
    }

    public TopicDto updateTopic(Long id, TopicDto topicDto) {
        // Add logic for updating a topic
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setName(topicDto.getName());
            Topic updatedTopic = topicRepository.save(topic);

            TopicDto updatedTopicDto = new TopicDto();
            updatedTopicDto.setId(updatedTopic.getId());
            updatedTopicDto.setName(updatedTopic.getName());

            return updatedTopicDto;
        } else {
            return null;
        }
    }

    public void deleteTopic(Long id) {
        // Add logic for deleting a topic
        topicRepository.deleteById(id);
    }

    public TopicDto getTopic(Long id) {
        // Add logic for retrieving a topic
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            TopicDto topicDto = new TopicDto();
            topicDto.setId(topic.getId());
            topicDto.setName(topic.getName());

            return topicDto;
        } else {
            return null;
        }
    }

    public List<TopicDto> getAllTopics() {
        // Add logic for retrieving all topics
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(topic -> {
            TopicDto topicDto = new TopicDto();
            topicDto.setId(topic.getId());
            topicDto.setName(topic.getName());
            return topicDto;
        }).collect(Collectors.toList());
    }

    // Add any additional methods or configurations required for TopicService
}
