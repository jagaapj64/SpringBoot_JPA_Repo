package com.example.annotation.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(@PropertySource(value="classpath:env.properties"))
public class SpringBootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

}
