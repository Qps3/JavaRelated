package org.example.myapp.services.user;

import org.example.myapp.user.User; // 确保导入正确的User类
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRedisService userRedisService;

    @Autowired
    public UserService(UserRedisService userRedisService) {
        this.userRedisService = userRedisService;
    }

    // 用户注册方法
    public void registerUser(User user) {
        // ... 其他注册逻辑

        // 调用 UserRedisService 的方法保存用户信息到 Redis
        userRedisService.saveUser(user);
    }

    // 其他方法省略...
}
