package org.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MyApplication {

    //访问chat_ai http://localhost:8080/ai_chat.html

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void run() {
        String port = env.getProperty("server.port");
        String url = "http://localhost:" + port;
        System.out.println("应用程序已启动，可以访问网址：" + url);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:63342")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true)
                        .allowedHeaders("*");
            }
        };
    }
}
