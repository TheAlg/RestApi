package com.reservation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.reservation.exception.ReservationNotFoundException;
import com.reservation.exception.hotelNotFoundException;
import com.reservation.models.hotel;
import com.reservation.repositories.hotelRepository;


@RestController
@RequestMapping("hotels/api")
public class HotelController {
	
	@Autowired
	private hotelRepository hotelRepository;
	
	
	@GetMapping("/hotels")
	public List<hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@GetMapping("/hotels/{id}")
	public hotel getHotelById(@PathVariable long id) throws hotelNotFoundException {
		return hotelRepository.findById(id)
			 .orElseThrow(()-> new hotelNotFoundException("erreur, l'hotel " + id + " n'a pas été retrouvé"));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteReservation(@PathVariable long id) throws ReservationNotFoundException {
			hotel hotel =  hotelRepository.findById(id)
					 .orElseThrow(()->
					 new ReservationNotFoundException("erreur, la réservation " + id + " n'a pas été retrouvé"));
			hotelRepository.delete(hotel);
		}
	
	 
}
