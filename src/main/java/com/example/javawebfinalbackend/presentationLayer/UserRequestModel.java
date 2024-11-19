package com.example.javawebfinalbackend.presentationLayer;

import lombok.*;

import java.util.Date;

@Data
public class UserRequestModel {
    private String userName;
    private String email;
    private String passwordHash;
    private Date dob;
    private String profilePictureUrl;
    private String bio;

}
