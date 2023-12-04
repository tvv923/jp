package edu.hillel.service1.controller;

import edu.hillel.service1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/byKeyword")
    public ResponseEntity<List<String>> getNewsByKeyword(@RequestParam String keyword) {
        List<String> news = newsService.getNewsByKeyword(keyword);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
