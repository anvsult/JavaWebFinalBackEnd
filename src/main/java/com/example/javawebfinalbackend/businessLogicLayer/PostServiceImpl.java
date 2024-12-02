package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Post;
import com.example.javawebfinalbackend.dataAccessLayer.PostRepository;
import com.example.javawebfinalbackend.dataAccessLayer.User;
import com.example.javawebfinalbackend.dataAccessLayer.UserRepository;
import com.example.javawebfinalbackend.presentationLayer.PostRequestModel;
import com.example.javawebfinalbackend.presentationLayer.PostResponseModel;
import com.example.javawebfinalbackend.dataMapperLayer.PostResponseMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
//    Repositories
    private final PostRepository postRepository;
    private final UserRepository userRepository;
//    Mappers
    private final PostResponseMapper postResponseMapper;

    public PostServiceImpl(
            PostRepository postRepository,
            PostResponseMapper postResponseMapper,
            UserRepository userRepository
    ) {
        this.postRepository = postRepository;
        this.postResponseMapper = postResponseMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostResponseModel> getPosts() {
        List<Post> posts = postRepository.findAll();
        return postResponseMapper.entityListToResponseModelList(posts);
    }

    @Override
    public PostResponseModel getPostById(int postId) {
        Post post = postRepository.findPostByPostId(postId);
        return postResponseMapper.entityToResponseModel(post);
    }

    @Override
    public PostResponseModel createPost(PostRequestModel post) {
        Post newPost = new Post();
        newPost.setUser(userRepository.findUserByUserId(post.getUserId()));

        newPost.setPostImageUrl(post.getPostImageUrl());
        newPost.setPostDescription(post.getPostDescription());
        newPost.setCreatedAt(new Date());

        postRepository.save(newPost);
        return postResponseMapper.entityToResponseModel(newPost);
    }

    @Override
    public String editPost(int postId, PostRequestModel post) {
        Post postToEdit = postRepository.findPostByPostId(postId);

        postToEdit.setPostImageUrl(post.getPostImageUrl());
        postToEdit.setPostDescription(post.getPostDescription());

        postRepository.save(postToEdit);
        return "Post edited successfully";
    }

    @Override
    public String deletePost(int postId) {
        Post postToDelete = postRepository.findPostByPostId(postId);
        postRepository.delete(postToDelete);
        return "Post deleted successfully";
    }

    @Override
    public List<PostResponseModel> getPostsByUserId(int userId) {
        User user = userRepository.findUserByUserId(userId);
        List<Post> posts = postRepository.findPostsByUser(user);
        return postResponseMapper.entityListToResponseModelList(posts);
    }
}
