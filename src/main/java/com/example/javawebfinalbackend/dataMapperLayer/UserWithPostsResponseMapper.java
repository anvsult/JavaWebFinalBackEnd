package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.presentationLayer.UserWithPostsResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserWithPostsResponseMapper {
//    @Mapping(target = "userId", source = "id")
//    @Mapping(target = "posts", source = "posts")
    UserWithPostsResponseModel entityToDTO(User user);

    List<UserWithPostsResponseModel> entityListToDTOList(List<User> users);
}
