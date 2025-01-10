package org.example.myapp.controller.user;


import org.example.myapp.services.user.UserService;
import org.example.myapp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // 调用UserService的registerUser方法进行用户注册
        userService.registerUser(user);

        // 注册成功后，可以跳转到登录页面或其他页面
        return "redirect:/login"; // 假设登录页面的URL是/login
    }
}
