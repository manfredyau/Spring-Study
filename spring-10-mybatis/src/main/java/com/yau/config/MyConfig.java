package com.yau.config;

import com.yau.pojo.Group;
import com.yau.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@ComponentScan
public class MyConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Group group() {
        return new Group();
    }
}
