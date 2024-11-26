package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.presentationLayer.UserRequestModel;
import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;

public interface UserService {
    UserResponseModel getUserById(int userId);
    String createUser(UserRequestModel user);
    String updateUser(int userId, UserRequestModel user);
    String deleteUser(int userId);
}
