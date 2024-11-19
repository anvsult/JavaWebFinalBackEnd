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

    @GetMapping("/{user_id}")
    public List<FriendshipResponseModel> getFriendshipsByUserId(@PathVariable int user_id) {
        return friendshipService.getFriendshipsByUserId(user_id);
    }

    @PostMapping("/send")
    public String sendFriendRequest(@RequestParam int sourceId, @RequestParam int targetId) {
        return friendshipService.sendFriendRequest(sourceId, targetId);
    }

    @PostMapping("/accept/{friendship_id}")
    public String acceptFriendRequest(@PathVariable int friendship_id) {
        return friendshipService.acceptFriendRequest(friendship_id);
    }

    @PostMapping("/decline/{friendship_id}")
    public String declineFriendRequest(@PathVariable int friendship_id) {
        return friendshipService.declineFriendRequest(friendship_id);
    }

    @DeleteMapping("/delete/{friendship_id}")
    public String deleteFriendship(@PathVariable int friendship_id) {
        return friendshipService.deleteFriendship(friendship_id);
    }

}
