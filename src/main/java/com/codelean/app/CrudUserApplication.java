package com.codelean.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.codelean")
public class CrudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUserApplication.class, args);
	}

}
