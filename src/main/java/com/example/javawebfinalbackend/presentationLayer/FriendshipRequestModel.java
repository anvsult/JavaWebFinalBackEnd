package com.example.javawebfinalbackend.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FriendshipRequestModel {
    private int source_id;
    private int target_id;
}
