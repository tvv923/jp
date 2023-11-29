package edu.hillel.service1.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import edu.hillel.service1.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public List<String> getNewsByKeyword(String keyword) {
        String apiKey = restTemplateConfig.getApiKey();
        List<String> processedTitles = new ArrayList<>();

        NewsApiClient newsApiClient = new NewsApiClient(apiKey);
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q(keyword)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        processedTitles.addAll(response.getArticles().stream()
                                .map(article -> "Glory to Ukraine - " + article.getTitle())
                                .collect(Collectors.toList()));
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        return processedTitles;
    }
}