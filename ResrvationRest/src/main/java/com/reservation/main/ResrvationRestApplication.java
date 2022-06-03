package com.reservation.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {
		"com.reservation.models"
})
@EnableJpaRepositories( basePackages = {
		"com.reservation.repositories"
})
@SpringBootApplication(scanBasePackages = {
		"com.reservation.exception",
		"com.reservation.controllers"
})

public class ResrvationRestApplication {


	public static void main(String[] args) {
		SpringApplication.run(ResrvationRestApplication.class, args);
		}


	

}
