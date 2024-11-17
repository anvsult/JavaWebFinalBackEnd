package com.example.javawebfinalbackend.dataMapperLayer;

import com.example.javawebfinalbackend.dataAccessLayer.Post;
import com.example.javawebfinalbackend.presentationLayer.PostResponseModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PostResponseMapper {
    PostResponseModel entityToResponseModel(Post post);
}
