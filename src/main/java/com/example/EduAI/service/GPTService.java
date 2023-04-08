package com.example.EduAI.service;

import com.example.EduAI.dto.ResourceDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class GPTService {

    @Value("${gpt3.api.key}")
    private String apiKey;

    public List<ResourceDto> generateResourceSuggestions(String topicName) {
        List<ResourceDto> resources = new ArrayList<>();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        String prompt = "Generate a list of resources for learning the topic \"" + topicName + "\".";

        String requestBody = "{"
                + "\"model\": \"text-davinci-002\","
                + "\"prompt\": \"" + prompt + "\","
                + "\"max_tokens\": 100,"
                + "\"n\": 1,"
                + "\"stop\": \"\\n\","
                + "\"temperature\": 0.8"
                + "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/engines/davinci-codex/completions"))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseObject = objectMapper.readTree(response.body());
                JsonNode choicesArray = responseObject.get("choices");
                JsonNode choiceObject = choicesArray.get(0);
                String text = choiceObject.get("text").asText();

                String[] resourceLines = text.trim().split("\n");

                for (String resourceLine : resourceLines) {
                    String[] parts = resourceLine.split(" - ");
                    if (parts.length == 2) {
                        ResourceDto resourceDto = new ResourceDto();
                        resourceDto.setName(parts[0].trim());
                        resourceDto.setUrl(parts[1].trim());
                        resources.add(resourceDto);
                    }
                }
            } else {
                System.err.println("Error: " + response.statusCode() + " - " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return resources;
    }

}
