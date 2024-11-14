package com.example.javawebfinalbackend.dataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String post_image_url;
    private String post_description;
    private LocalDateTime create_at;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
