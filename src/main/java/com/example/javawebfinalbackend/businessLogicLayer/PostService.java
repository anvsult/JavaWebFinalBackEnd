package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.presentationLayer.PostRequestModel;
import com.example.javawebfinalbackend.presentationLayer.PostResponseModel;

import java.util.List;

public interface PostService {
    PostResponseModel getPostById(int postId);
    PostResponseModel createPost(PostRequestModel post);
    String editPost(int postId, PostRequestModel post);
    String deletePost(int postId);
    List<PostResponseModel> getPostsByUserId(int userId);
    List<PostResponseModel> getPosts();
}
