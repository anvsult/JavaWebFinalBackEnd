package com.example.javawebfinalbackend.presentationLayer;

import com.example.javawebfinalbackend.businessLogicLayer.UserServiceImpl;
import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{user_id}")
    public UserResponseModel getUser(@PathVariable int user_id) {
        return this.userService.getUserById(user_id);
    }

    @PostMapping
    public String createUser(@RequestBody UserRequestModel newUser) {
        return this.userService.createUser(newUser);
    }

    @PutMapping("/{user_id}")
    public String updateUser(@PathVariable int user_id, @RequestBody UserRequestModel user) {
        return userService.updateUser(user_id, user);
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable int user_id) {
        return this.userService.deleteUser(user_id);
    }
}
