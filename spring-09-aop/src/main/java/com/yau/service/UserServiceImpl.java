package com.yau.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("Add a user.");
    }

    @Override
    public void delete(int id) {
        System.out.println("Delete a user.");
    }

    @Override
    public void update() {
        System.out.println("Update a user.");
    }

    @Override
    public void select() {
        System.out.println("Select a user.");
    }
}
