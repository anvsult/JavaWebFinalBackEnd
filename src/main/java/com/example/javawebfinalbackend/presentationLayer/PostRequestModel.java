package com.example.javawebfinalbackend.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostRequestModel {
    private String post_image_url;
    private String post_description;

}
