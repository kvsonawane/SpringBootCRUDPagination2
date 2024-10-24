package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.springboot")

public class SpringBootCrudPagination2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudPagination2Application.class, args);
	}

}
