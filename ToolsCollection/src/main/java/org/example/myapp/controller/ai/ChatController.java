package org.example.myapp.controller.ai;

import org.example.myapp.services.ai.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:63342")
public class ChatController {

    private final RedisService redisService;

    @Autowired
    public ChatController(RedisService redisService) {
        this.redisService = redisService;
    }



    @PostMapping("/save-all-chat-to-redis")
    public ResponseEntity<String> saveAllChatToRedis(@RequestBody List<Map<String, String>> chatHistory) {
        try {
            redisService.saveChatHistory(chatHistory);
            return ResponseEntity.ok("All chat data saved to Redis successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving all chat data to Redis: " + e.getMessage());
        }
    }


}
