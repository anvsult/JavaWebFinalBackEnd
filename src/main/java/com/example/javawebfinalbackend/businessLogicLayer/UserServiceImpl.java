package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.dataMapperLayer.UserResponseMapper;
import com.example.javawebfinalbackend.presentationLayer.UserRequestModel;
import com.example.javawebfinalbackend.presentationLayer.UserResponseModel;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    Repositories
    private UserRepository userRepository;
//    Mappers
    private UserResponseMapper userResponseMapper;

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
        return userResponseMapper.entityToResponseModel(user);
    }

    @Override
    public String createUser(UserRequestModel user) {
        User newUser = new User();
        newUser.setUser_name(user.getUser_name());
        newUser.setEmail(user.getEmail());
        newUser.setPassword_hash(user.getPassword_hash());
        userRepository.save(newUser);
        return "User created successfully";
    }

    @Override
    public String updateUser(int userId, UserRequestModel user) {
        User userToEdit = userRepository.findUserByUserId(userId);
        userToEdit.setUser_name(user.getUser_name());
        userToEdit.setEmail(user.getEmail());
        userToEdit.setPassword_hash(user.getPassword_hash());
        userRepository.save(userToEdit);
        return "User edited successfully";
    }

    @Override
    public String deleteUser(int userId) {
        User userToDelete = userRepository.findUserByUserId(userId);
        userRepository.delete(userToDelete);
        return "User deleted successfully";
    }

}
