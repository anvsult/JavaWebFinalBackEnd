package com.example.javawebfinalbackend.presentationLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import lombok.*;

@Data
public class PostRequestModel {
    private Integer userId;
    private String postImageUrl;
    private String postDescription;

}
