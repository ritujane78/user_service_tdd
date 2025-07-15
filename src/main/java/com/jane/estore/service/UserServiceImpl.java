package com.jane.estore.service;

import com.jane.estore.data.UsersRepository;
import com.jane.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    UsersRepository usersRepository;
    EmailNotificationService emailNotificationService;

    public UserServiceImpl(UsersRepository usersRepository, EmailNotificationService emailNotificationService){
        this.usersRepository = usersRepository;
        this.emailNotificationService = emailNotificationService;

    }
    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String confirmPassword) {
        if(firstName == null || firstName.trim().length() == 0){
            throw new IllegalArgumentException("User's first name is empty");
        }
        if(lastName == null || lastName.trim().length() == 0){
            throw new IllegalArgumentException("User's last name is empty");
        }
        if(email == null || email.trim().length() == 0){
            throw new IllegalArgumentException("User's email is empty");
        }
        User user = new User(firstName,lastName,email,UUID.randomUUID().toString(), password,confirmPassword);
        boolean isUserCreated;

        try{
            isUserCreated = usersRepository.save(user);
        } catch(RuntimeException ex){
            throw new UserServiceException(ex.getMessage());
        }

        if(!isUserCreated) throw new UserServiceException("Could not create user.");

        try{
            emailNotificationService.scheduleEmailConfirmation(user);
        } catch(RuntimeException ex){
            throw new UserServiceException(ex.getMessage());
        }
        return user;
    }
}
