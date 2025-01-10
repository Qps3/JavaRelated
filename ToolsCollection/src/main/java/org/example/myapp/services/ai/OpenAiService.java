package org.example.myapp.services.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OpenAiService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    // Here we use the @Value annotation to read the API keys from the application.properties file
    @Value("#{'${openai.api.keys}'.split(',')}")
    private List<String> apiKeys;

    private final RestTemplate restTemplate = new RestTemplate();

    private int currentApiKeyIndex = 0;
    private int currentCallCount = 0;

    public String generateText(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + getCurrentApiKey());

        // We are including only some of the parameters to the json request
        String requestJson = "{\"model\": \"gpt-3.5-turbo\", \"messages\":[{\"role\":\"system\",\"content\":\"You are a helpful assistant.\"},{\"role\":\"user\",\"content\":\"" + prompt + "\"}]}";

        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, request, String.class);

        // 解析响应中的AI回答
        String aiResponse = "";
        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            aiResponse = rootNode.path("choices").get(0).path("message").path("content").asText();
            currentCallCount++;
            if (currentCallCount >= 3) {
                currentCallCount = 0;
                currentApiKeyIndex = (currentApiKeyIndex + 1) % apiKeys.size();
            }
        } catch (Exception e) {
            // Handle the exception as you see fit
        }

        return aiResponse;
    }

    private String getCurrentApiKey() {
        return apiKeys.get(currentApiKeyIndex);
    }
}
