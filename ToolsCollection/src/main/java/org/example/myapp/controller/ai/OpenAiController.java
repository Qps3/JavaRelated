package org.example.myapp.controller.ai;

import org.example.myapp.services.ai.OpenAiService;
import org.example.myapp.services.ai.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // 允许所有源进行访问
public class OpenAiController {

    private final OpenAiService openAiService;
    private final RedisService redisService;

    @Autowired
    public OpenAiController(OpenAiService openAiService, RedisService redisService) {
        this.openAiService = openAiService;
        this.redisService = redisService;
    }

    @GetMapping("/generate-text")
    public String generateText(@RequestParam String prompt) {
        String aiResponse = openAiService.generateText(prompt);
        return "<html><body><p>" + aiResponse + "</p></body></html>";
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, String> messageData) {
        String sender = messageData.get("sender");
        String message = messageData.get("message");
        if (sender != null && message != null) {
            // 将sender和message打包成一个Map
            Map<String, String> chatMessage = new HashMap<>();
            chatMessage.put("sender", sender);
            chatMessage.put("message", message);
            // 在这里将聊天数据保存到Redis中
            redisService.saveChatHistory(Collections.singletonList(chatMessage));
            return ResponseEntity.ok("Message saved successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid message data.");
        }
    }

}
