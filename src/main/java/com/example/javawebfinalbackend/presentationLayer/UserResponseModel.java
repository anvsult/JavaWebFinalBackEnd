package com.example.javawebfinalbackend.presentationLayer;

import lombok.*;

import java.util.Date;

@Data
public class UserResponseModel {
    private Integer userId;
    private String userName;
    private String email;
    private Date registeredAt;
    private Date dob;
    private String profilePictureUrl;
    private String bio;
}
