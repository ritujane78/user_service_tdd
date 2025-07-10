package com.jane.estore.service;

import com.jane.estore.model.User;
import com.jane.estore.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @Test
    void teatCreateUser_whenUserDetailsProvided_returnUserProject() {
//        Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "Ritu";
        String lastName = "Bafna";
        String email = "ritujane78@gmail.com";
        String password = "test123";
        String confirmPassword = "test123";
//        Act
        User user = userService.createUser(firstName,lastName,email,password,confirmPassword);

//         Assert
        assertNotNull(user,"The createUserr() should not have returnd null");
    }
}