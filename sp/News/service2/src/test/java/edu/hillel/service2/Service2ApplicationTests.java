package edu.hillel.service2;

import edu.hillel.service2.config.RestTemplateConfig;
import edu.hillel.service2.service.NewsDisplayService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class NewsDisplayServiceTest {

	@Mock
	private RestTemplateConfig restTemplateConfig;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private NewsDisplayService newsDisplayService;

	@Test
	void displayNewsByKeyword() {
		String keyword = "test";
		String firstServiceUrl = "http://example.com";
		List<String> expectedNews = Collections.singletonList("Test News");

		Mockito.when(restTemplateConfig.getFirstServiceUrl()).thenReturn(firstServiceUrl);

		ResponseEntity<List<String>> responseEntity = ResponseEntity.ok(expectedNews);
		Mockito.when(restTemplate.exchange(
				Mockito.eq(firstServiceUrl + "/api/news/byKeyword?keyword=" + keyword),
				Mockito.eq(HttpMethod.GET),
				Mockito.isNull(),
				Mockito.eq(new ParameterizedTypeReference<List<String>>() {
				})
		)).thenReturn(responseEntity);

		newsDisplayService.displayNewsByKeyword(keyword);

		Mockito.verify(restTemplate, Mockito.times(1)).exchange(
				Mockito.eq(firstServiceUrl + "/api/news/byKeyword?keyword=" + keyword),
				Mockito.eq(HttpMethod.GET),
				Mockito.isNull(),
				Mockito.eq(new ParameterizedTypeReference<List<String>>() {
				})
		);
	}
}
