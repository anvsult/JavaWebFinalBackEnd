package com.example.javawebfinalbackend.presentationLayer;

import com.example.javawebfinalbackend.businessLogicLayer.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/{post_id}")
    public List<PostResponseModel> getPostById(@PathVariable int post_id) {
        return this.postService.getPostById(post_id);
    }

    @PostMapping
    public List<PostResponseModel> createPost(@RequestBody PostRequestModel create_post) {
        return this.postService.createPost(create_post);
    }

    @PutMapping("/{post_id}")
    public String editPost(@PathVariable int post_id, @RequestBody PostRequestModel edit_post) {
        return this.postService.editPost(post_id, edit_post);
    }

    @DeleteMapping("/{post_id}")
    public String deletePost(@PathVariable int post_id) {
        return this.postService.deletePost(post_id);
    }

    @GetMapping("/users/{user_id}/posts")
    public List<PostResponseModel> getPostsByUser(@PathVariable int user_id) {
        return this.postService.getPostsByUser(user_id);
    }

}
