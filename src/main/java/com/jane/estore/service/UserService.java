package com.jane.estore.service;

import com.jane.estore.model.User;

public interface UserService {
    User createUser(String firstName,
                    String lastName,
                    String email,
                    String password,
                    String confirmPassword);
}
