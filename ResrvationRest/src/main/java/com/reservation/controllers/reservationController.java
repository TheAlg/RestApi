package com.reservation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.reservation.models.Agency;
import com.reservation.models.Offre;
import com.reservation.models.chambre;
import com.reservation.models.hotel;
import com.reservation.models.reservation;
import com.reservation.repositories.AgencyRepository;
import com.reservation.repositories.reservationRepository;


@RestController
public class reservationController {
	
	@Autowired
	private reservationRepository reservationRepository;
	@Autowired
	public AgencyRepository agencyRepository;

	private static final String uri ="hotels/api";
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value=uri+"/reserver")
	public reservation reserver (@RequestBody Offre offre)  {
		
		//je ne peux pas poster une reservation directement car j'ai une base de donnée assez complex (plusieurs foreign keys)
		//j'ai donc rassembé tout les paramètres dans un seul objet offre
		chambre chambre = new chambre();
		Agency agence =agencyRepository.findById(offre.getAgence_id()).get();
		
		for (hotel h : agence.getHotels()) {
			for (chambre c : h.getChambres()) {
				if (c.getId() == offre.getChambre_id()) {
					chambre = c;
				}
			}
		}		
		reservation r = new reservation();
		r.setChambre_id(chambre);
		r.setArrival(offre.getArrival());
		r.setDeparture(offre.getDeparture());
		r.setCb(offre.getCb());
		r.setName(offre.getName());
		r.setLastname(offre.getLastName());
		r.setReference(offre.getReservationReference());
			
		if (reservationRepository.save(r) != null) {
			chambre.getArrivals().add(offre.getArrival());
			chambre.getDepartures().add(offre.getDeparture());
		}
		
		System.out.println("Réservation enregistrée: veuillez conserver votre numéro de reservation :" + offre.getReservationReference() +"\n" 
				+" votre date d'arrivée :" + offre.getArrival()+ "\n"
				+" votre date de départ :" + offre.getDeparture());
		

		return r;
		
	}
	


}
