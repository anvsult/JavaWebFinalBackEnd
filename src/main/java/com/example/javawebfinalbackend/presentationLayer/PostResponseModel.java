package com.example.javawebfinalbackend.presentationLayer;

import lombok.*;

import java.util.Date;

@Data
public class PostResponseModel {
    private Integer postId;
    private Integer userId;
    private String postImageUrl;
    private String postDescription;
    private Date createdAt;

}
