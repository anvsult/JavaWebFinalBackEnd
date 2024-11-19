package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Friendship;
import com.example.javawebfinalbackend.presentationLayer.FriendshipResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FriendshipResponseMapper {
    @Mapping(source = "sourceUser.userId", target = "sourceUserId")
    @Mapping(source = "sourceUser.userName", target = "sourceUserName")
    @Mapping(source = "targetUser.userId", target = "targetUserId")
    @Mapping(source = "targetUser.userName", target = "targetUserName")
    @Mapping(source = "status", target = "status")
    FriendshipResponseModel entityToResponseModel(Friendship friendship);

    List<FriendshipResponseModel> entityListToResponseModelList(List<Friendship> friendships);
}
