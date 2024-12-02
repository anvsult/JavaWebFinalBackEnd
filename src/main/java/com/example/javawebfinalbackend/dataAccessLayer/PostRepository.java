package com.example.javawebfinalbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostByPostId(Integer postId);
    List<Post> findPostsByUser(User user);

}
