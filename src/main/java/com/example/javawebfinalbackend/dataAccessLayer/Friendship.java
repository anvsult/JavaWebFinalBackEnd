package com.example.javawebfinalbackend.dataAccessLayer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "friendships", uniqueConstraints = {@UniqueConstraint(columnNames = {"source_id", "target_id"})})
@Data
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipId;

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private User sourceUser;

    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private User targetUser;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;

    private Date createdAt;

}