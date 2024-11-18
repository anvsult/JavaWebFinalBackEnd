package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseModel entityToResponseModel(User user);
}
