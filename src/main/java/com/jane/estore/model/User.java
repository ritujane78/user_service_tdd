package com.jane.estore.model;

public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;
    String id;

    public User(String firstName, String lastName, String email, String id, String password,String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
