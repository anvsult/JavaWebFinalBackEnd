package com.example.javawebfinalbackend.presentationLayer;

import com.example.javawebfinalbackend.businessLogicLayer.FriendshipService;
import com.example.javawebfinalbackend.businessLogicLayer.FriendshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {
    private FriendshipServiceImpl friendshipService;

    @Autowired
    public FriendshipController(FriendshipServiceImpl friendshipService) {
        this.friendshipService = friendshipService;
    }

//    @PostMapping
//    public List<FriendshipResponseModel> sendFriendRequest(@RequestBody FriendshipRequestModel request) {
//        return this.friendshipService.sendFriendRequest(request);
//    }
//
//    @PutMapping("/{friendship_id}/accept")
//    public List<FriendshipResponseModel> acceptFriendRequest(@PathVariable int friendship_id) {
//        return this.friendshipService.acceptFriendRequest(friendship_id);
//    }
//
//    @DeleteMapping("/{friendship_id}")
//    public List<Void> deleteFriendRequest(@PathVariable int friendship_id) {
//        return this.friendshipService.deleteFriendRequest(friendship_id);
//    }
//
//    @PostMapping("/{friendship_id}/block")
//    public List<Void> blockUser(@PathVariable int friendship_id) {
//        return this.friendshipService.blockUser(friendship_id);
//    }

}
