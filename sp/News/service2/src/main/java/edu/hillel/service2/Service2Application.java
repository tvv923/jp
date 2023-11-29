package edu.hillel.service2;

import edu.hillel.service2.service.NewsDisplayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Service2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Service2Application.class, args);
		NewsDisplayService newsDisplayService = context.getBean(NewsDisplayService.class);

		try {
			newsDisplayService.displayNewsByKeyword("business");
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}
}
