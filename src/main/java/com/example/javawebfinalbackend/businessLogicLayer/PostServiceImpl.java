package com.example.javawebfinalbackend.businessLogicLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Post;
import com.example.javawebfinalbackend.dataAccessLayer.PostRepository;
import com.example.javawebfinalbackend.presentationLayer.PostResponseModel;
import com.example.javawebfinalbackend.dataMapperLayer.PostResponseMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
//    Repositories
    private final PostRepository postRepository;
//    Mappers
    private final PostResponseMapper postReponseMapper;

    public PostServiceImpl(
            PostRepository postRepository,
            PostResponseMapper postResponseMapper
    ) {
        this.postRepository = postRepository;
        this.postReponseMapper = postResponseMapper;
    }

    @Override
    public PostResponseModel getPostById(int postId) {
        Post post = postRepository.findPostByPostId(postId);
        return postReponseMapper.entityToResponseModel(post);
    }
}
