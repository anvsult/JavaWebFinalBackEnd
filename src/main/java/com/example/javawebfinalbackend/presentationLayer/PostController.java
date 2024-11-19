package com.example.javawebfinalbackend.presentationLayer;

import com.example.javawebfinalbackend.businessLogicLayer.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/{post_id}")
    public PostResponseModel getPostById(@PathVariable int post_id) {
        return postService.getPostById(post_id);
    }

    @PostMapping
    public PostResponseModel createPost(@RequestBody PostRequestModel newPostData) {
        return postService.createPost(newPostData);
    }

    @PutMapping("/{post_id}")
    public String editPost(@PathVariable int post_id, @RequestBody PostRequestModel edit_post) {
        return postService.editPost(post_id, edit_post);
    }

    @DeleteMapping("/{post_id}")
    public String deletePost(@PathVariable int post_id) {
        return this.postService.deletePost(post_id);
    }

    @GetMapping("/users/{user_id}")
    public List<PostResponseModel> getPostsByUser(@PathVariable int user_id) {
        return postService.getPostsByUserId(user_id);
    }

}
