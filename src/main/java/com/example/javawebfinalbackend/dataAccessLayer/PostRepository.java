package com.example.javawebfinalbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
