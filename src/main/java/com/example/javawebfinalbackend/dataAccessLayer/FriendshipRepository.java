package com.example.javawebfinalbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    @Query("SELECT f FROM Friendship f WHERE f.source_id = :user OR f.target_id = :user")
    List<Friendship> findFriendshipsByUser(@Param("user") User source_id);
}
