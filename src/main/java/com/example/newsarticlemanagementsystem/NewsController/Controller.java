package com.example.newsarticlemanagementsystem.NewsController;

import com.example.newsarticlemanagementsystem.NewsApiResponse.ApiResponse;
import com.example.newsarticlemanagementsystem.NewsModel.News;
import com.example.newsarticlemanagementsystem.NewsService.NService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v/news")
@RequiredArgsConstructor
public class Controller {

    private final NService nService;

    @GetMapping("/get")
    public ResponseEntity getNews()
    {
        return ResponseEntity.status(200).body(nService.getNewsArrayList());
    }
    @PostMapping("/add")
    public ResponseEntity addNews(@Valid@RequestBody News news, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        nService.addNew(news);
        return ResponseEntity.status(200).body(new ApiResponse("news added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateNews(@PathVariable String id,@Valid@RequestBody News news,Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        if(nService.updateNew(id,news))
        {
            return ResponseEntity.status(200).body(new ApiResponse("news updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNews(@PathVariable String id)
    {
        if(nService.deleteNew(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("news deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @PutMapping("/publish/{id}")
    public ResponseEntity publishNews(@PathVariable String id)
    {
        if(nService.publishNew(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("news published"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found or it published"));
    }
    @GetMapping("/get-all-published")
    public ResponseEntity getAllPublished()
    {
       return ResponseEntity.status(200).body(nService.getAllPublishedNews());
    }
    @GetMapping("/get-by-category/{c}")
    public ResponseEntity getByCategory(@PathVariable String c)
    {
        return ResponseEntity.status(200).body(nService.newsArticleByCategory(c));
    }
}
