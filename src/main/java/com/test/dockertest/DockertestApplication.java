package com.test.dockertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockertestApplication {

	public static void main(String[] args) {
		System.out.println("App Boots..");
		SpringApplication.run(DockertestApplication.class, args);
	}
}
