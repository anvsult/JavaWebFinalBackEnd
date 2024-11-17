package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.dataMapperLayer.UserResponseMapper;
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
        return UserResponseMapper.entityToResponseModel(user);
    }

}
