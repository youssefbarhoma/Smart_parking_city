package com.example.city.Controller;

import lombok.Data;

public class UserRegistrationDTO {
    private String name;
    private String email;
    private String password;

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}