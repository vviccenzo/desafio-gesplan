package com.example.desafiogesplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DesafiogesplanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiogesplanApplication.class, args);
	}
}
