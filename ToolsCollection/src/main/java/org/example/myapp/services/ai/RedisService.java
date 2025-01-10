package org.example.myapp.services.ai;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    // Change the key to "ch" instead of "chatHistory"
    private static final String CHAT_HISTORY_KEY = "m";

    @Autowired
    private RedisTemplate<String, String> redisTemplate; // Use RedisTemplate<String, String> for UTF-8 encoding

    public void saveChatHistory(List<Map<String, String>> chatHistory) {
        try {
            String chatHistoryJson = toJson(chatHistory); // Convert to JSON string
            redisTemplate.opsForValue().set(CHAT_HISTORY_KEY, chatHistoryJson); // Save JSON string to Redis
            LOGGER.info("保存聊天记录到Redis成功，数据量: {}", chatHistory.size());
        } catch (Exception e) {
            LOGGER.error("保存聊天记录到Redis时发生错误: {}", e.getMessage());
        }
    }

    public List<Map<String, String>> getChatHistory() {
        try {
            String chatHistoryJson = redisTemplate.opsForValue().get(CHAT_HISTORY_KEY); // Read JSON string from Redis
            List<Map<String, String>> chatHistory = fromJson(chatHistoryJson); // Convert JSON string back to List<Map>
            if (chatHistory != null) {
                LOGGER.info("从Redis获取聊天记录成功，数据量: {}", chatHistory.size());
            } else {
                LOGGER.info("从Redis获取聊天记录成功，但没有数据。");
            }
            return chatHistory != null ? chatHistory : new ArrayList<>();
        } catch (Exception e) {
            LOGGER.error("从Redis获取聊天记录时发生错误: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    // Utility method to convert List<Map> to JSON string
    private String toJson(List<Map<String, String>> data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    // Utility method to convert JSON string to List<Map>
    private List<Map<String, String>> fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Map<String, String>>>() {}.getType());
    }
}
