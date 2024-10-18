package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApi{

	public static void main(String[] args) {
		SpringApplication.run(BackEndApi.class, args);
		System.out.println("BACKEND INITIALIZED AT: " + LocalDate.now());
	}
}
