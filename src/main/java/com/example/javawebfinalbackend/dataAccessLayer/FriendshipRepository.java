package com.example.javawebfinalbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    @Query("SELECT f FROM Friendship f WHERE (f.sourceUser.userId = :sourceId AND f.targetUser.userId = :targetId) OR (f.sourceUser.userId = :targetId AND f.targetUser.userId = :sourceId)")
    Friendship findFriendshipBetweenUsers(@Param("sourceId") int sourceId, @Param("targetId") int targetId);


    @Query("SELECT f FROM Friendship f WHERE f.sourceUser.userId = :user OR f.targetUser.userId = :user")
    List<Friendship> findFriendshipsByUserId(@Param("user") int userId);

    Friendship findFriendshipsByFriendshipId(int friendshipId);
}
