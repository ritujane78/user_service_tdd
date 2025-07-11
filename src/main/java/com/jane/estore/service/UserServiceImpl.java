package com.jane.estore.service;

import com.jane.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String confirmPassword) {
        if(firstName == null || firstName.trim().length() == 0){
            throw new IllegalArgumentException("User's first name is empty");
        }
        User user = new User(firstName,lastName,email,UUID.randomUUID().toString());
        return user;
    }
}
