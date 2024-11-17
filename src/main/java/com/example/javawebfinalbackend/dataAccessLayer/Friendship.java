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
    private Integer friendship_id;

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private User source_id;

    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private User target_id;

    private Date created_at;
}