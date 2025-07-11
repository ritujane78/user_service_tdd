package com.jane.estore.service;

import com.jane.estore.model.User;
import com.jane.estore.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    UserService userService;
    String firstName ;
    String lastName ;
    String email;
    String password;
    String confirmPassword;
    @BeforeEach
    void init(){
        userService = new UserServiceImpl();
        firstName = "Ritu";
        lastName = "Bafna";
        email = "ritujane78@gmail.com";
        password = "test123";
        confirmPassword = "test123";

    }
    @DisplayName("User Object Created")
    @Test
    void teatCreateUser_whenUserDetailsProvided_returnUserProject() {

//        Act
        User user = userService.createUser(firstName,lastName,email,password,confirmPassword);

//         Assert
        assertNotNull(user,"The createUserr() should not have returnd null");
        assertEquals(firstName,user.getFirstName(),"First Name of the user is incorrect.");
        assertEquals(lastName,user.getLastName(),"Last Name of the user is incorrect.");
        assertEquals(email,user.getEmail(),"Email of the user is incorrect.");
        assertNotNull(user.getId(), " user id cannot be null");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateMethod_whenFirstNameIsEmpty_thowsIllegelArgumentException(){

//        Arrange
        firstName = "";
        String expectedException = "User's first name is empty";

//        Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName,lastName,email,password,confirmPassword);
        }, "Empty first name should have caused an illegal argument exception");

//        Assert
        assertEquals(expectedException, thrown.getMessage(),
                "Exception error message is not correct"
        );
    }
}