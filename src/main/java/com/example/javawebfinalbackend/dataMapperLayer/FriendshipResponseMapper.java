package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Friendship;
import com.example.javawebfinalbackend.presentationLayer.FriendshipResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FriendshipResponseMapper {
    List<FriendshipResponseModel> entityListToResponseModelList(List<Friendship> friendships);
}
