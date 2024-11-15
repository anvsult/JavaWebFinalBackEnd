package com.example.javawebfinalbackend.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FriendshipResponseModel {
    private Integer friendship_id;
    private Integer source_id;
    private Integer target_id;
    private Date created_at;
}
