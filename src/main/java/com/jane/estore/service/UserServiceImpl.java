package com.jane.estore.service;

import com.jane.estore.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String confirmPassword) {
        return new User();
    }
}
