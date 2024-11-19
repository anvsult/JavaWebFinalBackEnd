package com.example.javawebfinalbackend.presentationLayer;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostResponseModel {
    private Integer post_id;
    private Integer user_id;
    private String post_image_url;
    private String post_description;
    private Date created_at;

}
