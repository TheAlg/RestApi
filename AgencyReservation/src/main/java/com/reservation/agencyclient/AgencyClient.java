package com.reservation.agencyclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.reservation.models.hotel;

@Component
public class AgencyClient implements CommandLineRunner {
	
	public static void testcall () {
		RestTemplate t = new RestTemplate();
		hotel h = t.getForObject("http://localhost:8000/hotelservice/api/hotels/2", hotel.class);
		System.out.println("test" + h);
		
	}

	@Override
	public void run(String... args) throws Exception {
		testcall();		
	}

}
