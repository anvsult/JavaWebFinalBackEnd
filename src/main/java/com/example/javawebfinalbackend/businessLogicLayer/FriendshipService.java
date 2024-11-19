package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.presentationLayer.FriendshipResponseModel;

import java.util.List;

public interface FriendshipService {
    List<FriendshipResponseModel> getFriendshipsByUserId(int userId);
    String sendFriendRequest(int sourceUserId, int targetUserId);
    String acceptFriendRequest(int friendshipId);
    String declineFriendRequest(int friendshipId);
    String deleteFriendship(int friendshipId);
}
