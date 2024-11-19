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
    private final PostResponseMapper postReponseMapper;

    public PostServiceImpl(
            PostRepository postRepository,
            PostResponseMapper postResponseMapper,
            UserRepository userRepository
    ) {
        this.postRepository = postRepository;
        this.postReponseMapper = postResponseMapper;
        this.userRepository = userRepository;
    }

    @Override
    public PostResponseModel getPostById(int postId) {
        Post post = postRepository.findPostByPostId(postId);
        return postReponseMapper.entityToResponseModel(post);
    }

    @Override
    public PostResponseModel createPost(PostRequestModel post) {
        Post newPost = new Post();
        newPost.setUser(post.getUser());
        newPost.setPost_description(post.getPost_description());
        newPost.setCreated_at(new Date());
        postRepository.save(newPost);
        return postReponseMapper.entityToResponseModel(newPost);
    }

    @Override
    public String editPost(int postId, PostRequestModel post) {
        Post postToEdit = postRepository.findPostByPostId(postId);
        postToEdit.setPost_description(post.getPost_description());
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
        return postReponseMapper.entityListToResponseModelList(posts);
    }
}
