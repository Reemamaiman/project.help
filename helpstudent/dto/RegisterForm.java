package com.example.helpstudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data

public class RegisterForm {
    private String username;
    private String password;
    private String role;
    private String name;
    private String phonenumber;
    private String fullname;
    private String job;
    private String location;
    private String gender;
    private Integer age;

}

