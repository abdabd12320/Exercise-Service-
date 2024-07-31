package com.example.newsarticlemanagementsystem.NewsModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class News {

    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "title should not be empty")
    @Size(max = 100,message = "title should be less than 101 characters")
    private String title;
    @NotEmpty(message = "author should not be empty")
    @Size(min = 5,max = 20,message = "author must be between 5 and 20 characters")
    private String author;
    @NotEmpty(message = "content should not be empty")
    @Size(min = 201,message = "content should be more than 200 characters")
    private String content;
    @NotEmpty(message = "category should not be empty")
    @Pattern(regexp = "politics|sports|technology")
    private String category;
    @NotEmpty(message = "imageUrl should not be empty")
    private String imageUrl;
    @AssertFalse(message = "isPublished should be false")
    private boolean isPublished;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date publishDate;
}
