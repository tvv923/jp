package edu.hillel.service2.service;

import edu.hillel.service2.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsDisplayService {
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    @Autowired
    private RestTemplate restTemplate;

    public void displayNewsByKeyword(String keyword) {
        String firstServiceUrl = restTemplateConfig.getFirstServiceUrl();
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                firstServiceUrl + "/api/news/byKeyword?keyword=" + keyword,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                });

        List<String> news = responseEntity.getBody();
        news.forEach(System.out::println);
    }
}
