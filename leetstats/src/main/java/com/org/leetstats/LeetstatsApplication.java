package com.org.leetstats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.org.leetstats.repos")
@EnableAsync
public class LeetstatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetstatsApplication.class, args);
	}

}
