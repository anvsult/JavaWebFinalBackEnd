package com.example.javawebfinalbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    List<Friendship> findFriendshipsByUserId(Integer userId);
}
