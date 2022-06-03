package com.reservation.exemple.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.exemple.hotel.models",
		"com.exemple.hotel.client",
		"com.exemple.hotel.cli"
})
public class ResrvationRest1Application {



	public static void main(String[] args) {
		SpringApplication.run(ResrvationRest1Application.class, args);
	}

}
