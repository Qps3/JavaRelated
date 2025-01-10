package org.example.myapp.services.user;

import org.example.myapp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserRedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public UserRedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(User user) {
        try {
            String key = "users";
            String userId = user.getEmail();

            HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

            Map<String, String> userData = Map.of(
                    "email", user.getEmail(),
                    "username", user.getUsername(),
                    "password", user.getPassword()
            );

            hashOps.putAll(key + ":" + userId, userData);
            System.out.println("User data saved to Redis successfully: " + user.toString());
        } catch (Exception e) {
            System.err.println("Error saving user data to Redis: " + e.getMessage());
        }
    }
}
