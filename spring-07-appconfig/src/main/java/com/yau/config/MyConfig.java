package com.yau.config;

import com.yau.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class MyConfig {
    @Bean
    public User getUser() {
        User user = new User();
        user.setName("Manfred");
        System.out.println("Save Manfred");
        return user;
    }
}
