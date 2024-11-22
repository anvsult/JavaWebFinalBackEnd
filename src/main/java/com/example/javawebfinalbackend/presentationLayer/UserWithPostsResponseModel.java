package com.example.javawebfinalbackend.presentationLayer;

import lombok.Data;

import java.util.List;

@Data
public class UserWithPostsResponseModel {
    private int userId;
    private String userName;
    private String email;
    private List<PostResponseModel> posts;
}
