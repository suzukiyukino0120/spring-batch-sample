package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Batch1Application {

	public static void main(String[] args) {
		SpringApplication.run(Batch1Application.class, args);
	}

}
