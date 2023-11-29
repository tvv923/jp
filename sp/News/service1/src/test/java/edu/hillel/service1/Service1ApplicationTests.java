package edu.hillel.service1;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import edu.hillel.service1.config.RestTemplateConfig;
import edu.hillel.service1.service.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class NewsServiceTest {

    @Mock
    private RestTemplateConfig restTemplateConfig;

    @Mock
    private NewsApiClient newsApiClient;

    @InjectMocks
    private NewsService newsService;

    @Test
    void getNewsByKeyword() {
        String keyword = "test";
        String apiKey = "my_api_key";

        Mockito.when(restTemplateConfig.getApiKey()).thenReturn(apiKey);

        ArticleResponse articleResponse = new ArticleResponse();
        Article article = new Article();
        article.setTitle("Test Article");
        articleResponse.setArticles(Collections.singletonList(article));

        Mockito.doAnswer(invocation -> {
            NewsApiClient.ArticlesResponseCallback callback = invocation.getArgument(1);
            callback.onSuccess(articleResponse);
            return null;
        }).when(newsApiClient).getTopHeadlines(Mockito.any(), Mockito.any());

        List<String> result = newsService.getNewsByKeyword(keyword);

        Assertions.assertEquals(Collections.singletonList("Glory to Ukraine - Test Article"), result);
    }
}