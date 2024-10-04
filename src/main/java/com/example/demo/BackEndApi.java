package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackEndApi{

	public static void main(String[] args) {
		SpringApplication.run(BackEndApi.class, args);
		System.out.println("---------------------INICIALIZADO CON POLITICA CORS-------------------------");
	}
}
