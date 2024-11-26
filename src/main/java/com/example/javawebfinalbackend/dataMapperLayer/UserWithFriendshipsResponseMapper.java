package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.presentationLayer.UserWithFriendshipsResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FriendshipResponseMapper.class)
public interface UserWithFriendshipsResponseMapper {
//    @Mapping(target = "friendships", source = "friendships")
    UserWithFriendshipsResponseModel entityToResponseModel(User user);

    UserWithFriendshipsResponseModel entityListToResponseModelList(User user);
}
