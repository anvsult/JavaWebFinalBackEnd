package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Friendship;
import com.example.javawebfinalbackend.dataAccessLayer.FriendshipRepository;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.dataMapperLayer.FriendshipResponseMapper;
import com.example.javawebfinalbackend.presentationLayer.FriendshipResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService{
//    Repositories
    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;
//    Mappers
    private final FriendshipResponseMapper friendshipResponseMapper;

    public FriendshipServiceImpl(
            FriendshipRepository friendshipRepository,
            UserRepository userRepository,
            FriendshipResponseMapper friendshipResponseMapper
    ) {
        this.friendshipRepository = friendshipRepository;
        this.userRepository = userRepository;
        this.friendshipResponseMapper = friendshipResponseMapper;
    }

    @Override
    public List<FriendshipResponseModel> getFriendshipsByUserId(int userId) {
        List<Friendship> friendships = friendshipRepository.findFriendshipsByUserId(userId);
        return friendshipResponseMapper.entityListToResponseModelList(friendships);
    }
}

