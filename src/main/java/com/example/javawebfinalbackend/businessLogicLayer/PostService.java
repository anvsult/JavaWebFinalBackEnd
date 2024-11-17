package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.presentationLayer.PostResponseModel;

public interface PostService {
    PostResponseModel getPostById(int postId);
}
