package com.example.javawebfinalbackend.presentationLayer;

import lombok.*;

import java.util.Date;

@Data
public class PostResponseModel {
    private Integer userId;
    private Integer postId;
    private String userName;
    private String userImageUrl;
    private String postImageUrl;
    private String postDescription;
    private Date createdAt;

}
