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
public class UserResponseModel {
    private Integer user_id;
    private String user_name;
    private String email;
    private Date registered_at;
    private Date dob;
    private String profile_picture_url;
    private String bio;
}
