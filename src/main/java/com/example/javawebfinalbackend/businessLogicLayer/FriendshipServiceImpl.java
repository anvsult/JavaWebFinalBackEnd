package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Friendship;
import com.example.javawebfinalbackend.dataAccessLayer.FriendshipRepository;
import com.example.javawebfinalbackend.dataAccessLayer.FriendshipStatus;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.dataMapperLayer.FriendshipResponseMapper;
import com.example.javawebfinalbackend.presentationLayer.FriendshipResponseModel;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public String sendFriendRequest(int sourceId, int targetId) {
        Friendship existingFriendship = friendshipRepository.findFriendshipBetweenUsers(sourceId, targetId);
        if (existingFriendship != null) {
            if (FriendshipStatus.PENDING.equals(existingFriendship.getStatus())) {
                return "Friend request already sent";
            }
            if (FriendshipStatus.ACCEPTED.equals(existingFriendship.getStatus())) {
                return "Friendship already exists";
            }
            if (FriendshipStatus.DECLINED.equals(existingFriendship.getStatus())) {
                return "Friend request already declined";
            }
        }
        Friendship friendship = new Friendship();

        if (userRepository.findUserByUserId(sourceId) == null) {
            return "Source user not found";
        }
        if (userRepository.findUserByUserId(targetId) == null) {
            return "Target user not found";
        }
        friendship.setSourceUser(userRepository.findUserByUserId(sourceId));
        friendship.setTargetUser(userRepository.findUserByUserId(targetId));
        friendship.setStatus(FriendshipStatus.PENDING);
        friendship.setCreatedAt(new Date());

        friendshipRepository.save(friendship);
        return "Friend request sent successfully";
    }

    @Override
    public String acceptFriendRequest(int friendshipId) {
        if (friendshipRepository.findFriendshipsByFriendshipId(friendshipId) == null) {
            return "Friendship not found";
        }
        Friendship friendship = friendshipRepository.findFriendshipsByFriendshipId(friendshipId);

        if (!FriendshipStatus.PENDING.equals(friendship.getStatus())) {
            return "Friendship request cannot be accepted (It is not pending)";
        }
        friendship.setStatus(FriendshipStatus.ACCEPTED);
        friendshipRepository.save(friendship);
        return "Friend request accepted successfully";
    }

    @Override
    public String declineFriendRequest(int friendshipId) {
        if (friendshipRepository.findFriendshipsByFriendshipId(friendshipId) == null) {
            return "Friendship not found";
        }

        Friendship friendship = friendshipRepository.findFriendshipsByFriendshipId(friendshipId);
        if (!FriendshipStatus.PENDING.equals(friendship.getStatus())) {
            return "Friendship request cannot be declined (It is not pending)";
        }

        friendship.setStatus(FriendshipStatus.DECLINED);
        friendshipRepository.save(friendship);
        return "Friend request declined successfully";
    }

    @Override
    public String deleteFriendship(int friendshipId){
        if (friendshipRepository.findFriendshipsByFriendshipId(friendshipId) == null) {
            return "Friendship not found";
        }
        friendshipRepository.deleteById(friendshipId);
        return "Friendship deleted successfully";
    }
}

