package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseModel entityToResponseModel(User user);
}
