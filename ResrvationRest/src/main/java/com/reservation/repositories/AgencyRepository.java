package com.reservation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.models.Agency;


public interface AgencyRepository extends JpaRepository<Agency,Long> {
	
	// Select * from Hotel where id="x"
	//Optional<Agency> findById(Long id);
	
	// select * from Hotel
	//List<Agency> findAll(); 
	
	
	//@Query("FROM Agency AS agency LEFT JOIN rdt.hotel AS hotel WHERE agency.id = ?1")    //This is using a named query method
	//public List<hotel> findByAgency(Long id);
	
}
