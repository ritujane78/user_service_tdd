package com.jane.estore.service;

import com.jane.estore.model.User;
import com.jane.estore.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        password = "t est123@#$%123";
        confirmPassword = "test1234@#$%123";

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
    void testCreateMethod_whenFirstNameIsEmpty_throwsIllegelArgumentException(){

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

    @DisplayName("Empty last name causes correct exception")
    @Test
    void testCreateMethod_whenLastNameIsEmpty_throwIllegalArgumentException(){
        lastName = "";
        String exceptionMessage = "User's last name is empty";

//        Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName,lastName,email,password,confirmPassword);
        }, "Empty last name should throw an exception");

//    Assert
        assertEquals(exceptionMessage, thrown.getMessage(),
                "Exception message is incorrect");
    }
    @DisplayName("Empty email causes correct exception")
    @Test
    void testCreateMethod_whenEmailIsEmpty_throwIllegalArgumentException(){
        email = "";
        String exceptionMessage = "User's email is empty";

//        Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName,lastName,email,password,confirmPassword);
        }, "Empty email should throw an exception");

//    Assert
        assertEquals(exceptionMessage, thrown.getMessage(),
                "Exception message is incorrect");
    }
    @DisplayName("Same password while confirming")
    @Test
    void testCreateMethod_whenPasswordAndConfirmSame_returnUserObject(){
//        Act
        User user = userService.createUser(firstName,lastName, email, password, confirmPassword);

//        Assert
        assertTrue(user.getPassword() == user.getConfirmPassword(),"The password should match with the confirm password");

    }

    @DisplayName("Password is alphanumeric")
    @Test
    void testCreateMethod_whenPasswordNotAlphanumeric_returnUserObject(){
//        Act
        User user = userService.createUser(firstName,lastName, email, password, confirmPassword);
//        Assert
        assertTrue(user.getPassword().matches("[a-zA-Z0-9]+"),"Password should be alphanumeric");
    }

    @DisplayName("Password length check")
    @Test
    void testCreateMethod_whenPassswordNotEnoughLength_returuenUserObject(){
//        Arrange
        int threshold = 12;

//        Act
        User user = userService.createUser(firstName, lastName,email,password,confirmPassword);

//        Assert
        assertTrue(user.getPassword().length() > threshold, "String length should be greater than " +threshold);

    }
}

