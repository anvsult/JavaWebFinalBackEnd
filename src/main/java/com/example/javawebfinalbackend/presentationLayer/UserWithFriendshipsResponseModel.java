package com.example.javawebfinalbackend.presentationLayer;

import lombok.Data;

import java.util.List;

@Data
public class UserWithFriendshipsResponseModel {
    private Integer userId;
    private String username;
    private String email;

    private List<FriendshipResponseModel> friendships;
}
