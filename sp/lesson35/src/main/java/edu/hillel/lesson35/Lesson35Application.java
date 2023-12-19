package edu.hillel.lesson35;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "edu.hillel.lesson35.model")
@EnableJpaRepositories(basePackages = "edu.hillel.lesson35.repository")
public class Lesson35Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson35Application.class, args);
    }

}
