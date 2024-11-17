package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;

public interface UserService {
    UserResponseModel getUserById(int userId);
}
