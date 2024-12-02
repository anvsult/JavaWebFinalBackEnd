package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.dataMapperLayer.UserResponseMapper;
import com.example.javawebfinalbackend.presentationLayer.UserRequestModel;
import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
//    Repositories
    private final UserRepository userRepository;
//    Mappers
    private final UserResponseMapper userResponseMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            UserResponseMapper userResponseMapper
    ) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public UserResponseModel getUserById(int userId) {
        User user = userRepository.findUserByUserId(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found");
        }
        return userResponseMapper.entityToResponseModel(user);
    }

    @Override
    public String createUser(UserRequestModel user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());

        newUser.setPasswordHash(user.getPasswordHash());
        newUser.setRegisteredAt(new Date());
        newUser.setDob(user.getDob());
        newUser.setProfilePictureUrl(user.getProfilePictureUrl());
        newUser.setBio(user.getBio());

        userRepository.save(newUser);
        return "User created successfully";
    }

    @Override
    public String updateUser(int userId, UserRequestModel user) {
        User userToEdit = userRepository.findUserByUserId(userId);
        if (userToEdit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found");
        }
        userToEdit.setUserName(user.getUserName());
        userToEdit.setEmail(user.getEmail());

        userToEdit.setPasswordHash(user.getPasswordHash());
        userToEdit.setDob(user.getDob());
        userToEdit.setProfilePictureUrl(user.getProfilePictureUrl());
        userToEdit.setBio(user.getBio());

        userRepository.save(userToEdit);
        return "User edited successfully";
    }

    @Override
    public String deleteUser(int userId) {
        User userToDelete = userRepository.findUserByUserId(userId);
        if (userToDelete == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found");
        }
        userRepository.delete(userToDelete);
        return "User deleted successfully";
    }

}
