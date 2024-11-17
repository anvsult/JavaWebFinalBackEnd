package com.example.javawebfinalbackend.presentationLayer;

import lombok.Data;

import java.util.Date;

@Data
public class FriendshipResponseModel {
    private Integer friendshipId;
    private Integer sourceUserId;
    private String sourceUserName;
    private Integer targetUserId;
    private String targetUserName;
    private Date createdAt;
}
