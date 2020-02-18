package com.yau.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component(value = "p")
public class Person {
    private Cat cat;
    private Dog dog;
    private String name;

    /**
     * 只要 Cat 或 Dog 中有任意一個 Bean 沒有在 Spring容器 中找到，就會調用無參構造器
     */
    @Autowired(required = false)
    public Person(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    // 這個無參的構造器是很重要的，不要忽略掉
    public Person() {
        System.out.println("NO-ARGS' CTOR");
    }
}
