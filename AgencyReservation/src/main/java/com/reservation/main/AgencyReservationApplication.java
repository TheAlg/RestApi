package com.reservation.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) //sinon j'ai erreur failed to configure datasource
@ComponentScan({"com.reservation.agencyclient"})
public class AgencyReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyReservationApplication.class, args);
	}

}
