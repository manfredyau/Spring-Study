package com.yau.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class Group {
    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
