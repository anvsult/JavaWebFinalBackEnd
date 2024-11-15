package com.example.javawebfinalbackend.dataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String user_name;
    private String email;
    private String password_hash;
    private LocalDateTime registered_at;
    private LocalDateTime dob;
    private String profile_picture_url;
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "sourceUser", cascade = CascadeType.ALL)
    private List<Friendship> sentFriendRequests;

    @OneToMany(mappedBy = "targetUser", cascade = CascadeType.ALL)
    private List<Friendship> receivedFriendRequests;

}
