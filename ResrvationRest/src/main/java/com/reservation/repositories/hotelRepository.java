package com.reservation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.models.hotel;


public interface hotelRepository extends JpaRepository <hotel, Long>{

	//public hotel[] findByAgency(Long id);

	public hotel findByName(String name);
 
	// Select * from Hotel where id="x"
	//Optional<hotel> findById(Long id);
	
	// select * from Hotel
	//List<hotel> findAll(); 
		
	//public List<hotel> findByAgencyId(Long agency_id);

	//hotel findByName(String name);
}
