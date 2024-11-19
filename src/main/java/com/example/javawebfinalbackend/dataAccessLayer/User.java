package com.example.javawebfinalbackend.dataAccessLayer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;
    private String email;
    private String passwordHash;
    private Date registeredAt;
    private Date dob;
    private String profilePictureUrl;
    private String bio;

    @OneToMany(mappedBy = "sourceUser", cascade = CascadeType.ALL)
    private List<Friendship> sentFriendRequests;

    @OneToMany(mappedBy = "targetUser", cascade = CascadeType.ALL)
    private List<Friendship> receivedFriendRequests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
}
