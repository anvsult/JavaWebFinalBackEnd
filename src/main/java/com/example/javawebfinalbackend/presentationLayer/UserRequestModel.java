package com.example.javawebfinalbackend.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestModel {
    private String user_name;
    private String email;
    private String password_hash;
    private Date dob;
    private String profile_picture_url;
    private String bio;

}
