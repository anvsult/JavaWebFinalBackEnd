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
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "sourceId", nullable = false)
    private User source_id;

    @ManyToOne
    @JoinColumn(name = "targetId", nullable = false)
    private User target_id;

    private LocalDateTime createdAt;
}
