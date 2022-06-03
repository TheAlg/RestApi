package com.reservation.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.reservation.models.Agency;
import com.reservation.models.chambre;
import com.reservation.models.hotel;
import com.reservation.repositories.AgencyRepository;



@RestController
@RequestMapping("agences/api")
public class AgencyController {

	@Autowired
	public AgencyRepository agencyRepository;

	// returns all agency
	@GetMapping("/agencies")
	public List<Agency> getAllAgencies() {
		return agencyRepository.findAll();
	}

	// post new agency
	@PostMapping("/agencies")
	public Agency postHotel(@RequestBody Agency agency) {
		return agencyRepository.save(agency);
	}

	// update the agency entity (similar to the post)
	@PutMapping("/agencies")
	public void updateHotel(@RequestBody Agency agency) {
		agencyRepository.save(agency);
	}

	// get a specific agency based on the id
	@GetMapping("agencies/{id}")
	public Optional<Agency> getHotelFromId(@PathVariable Long id) {
		return agencyRepository.findById(id);
	}

	// delete an agency based on the id
	@DeleteMapping("/agencies/{id}")
	public void deleteHotel(@PathVariable Long id) {
		agencyRepository.deleteById(id);
	}
	
	//selectionner des chambres à partir de l'agence, le départ, l'arriver et le nombre de place
	@GetMapping(path = "/agencies/{id}/hotels")
	public  Agency hotelPreselectionnee (@PathVariable Long id, @RequestParam String Departure,@RequestParam String Arrival,@RequestParam int nblits){
		LocalDate departure = LocalDate.parse(Departure);
		LocalDate arrival = LocalDate.parse(Arrival);
		
		List<chambre> wanted = new ArrayList<>();

		//Agency newagency = new Agency();
		
		List<hotel> wantedhotel = new ArrayList<>();
		
		Agency agency = getHotelFromId(id).get();	
		
		
		for (hotel h : agency.getHotels()) {
			for (chambre c : h.getChambres()) {
				//settingprices
				double newprice = c.getPrice();
				if (id == 1) {newprice += newprice*0.1; }
				if (id == 2) {newprice += newprice*0.2; }
				if (id == 3) {newprice += newprice*0.3; }
				c.setPrice(newprice);

				//otherconditions
				if (verifierDate(c, departure, arrival)
					&& c.getNbPlace() >= nblits
					&& !wanted.contains(c)) {
						wanted.add(c);
				}
			}
			
			//garder uniquement les chambres qui nous intéressent 
			h.getChambres().retainAll(wanted);
			
			//garder uniquement les hotels qui nous intéressent
			if (! h.getChambres().isEmpty()
				&&!wantedhotel.contains(h)) {
				wantedhotel.add(h);
			}
		}
		agency.getHotels().retainAll(wantedhotel);

		return agency;
	}

	@GetMapping("/agencies/comparateur")
	public ArrayList<hotel> comparer ( @RequestParam String city,@RequestParam int nbetoile,@RequestParam String arrival,@RequestParam String departure, 
			 @RequestParam  int nblits) {
		
		ArrayList <hotel> listehotelfinale = new ArrayList<>();
		
		for (Long id =1L; id <3L; id++) {
			System.out.println(id);
			
			Agency agence = hotelPreselectionnee( id, departure, arrival, nblits);
			List <hotel> listehotelPreselectionne = agence.getHotels();
			for (hotel h : listehotelPreselectionne) {
				if (h.getAdress().getCity().equalsIgnoreCase(city)
						&& h.getStars() >= nbetoile
						&& !listehotelfinale.contains(h)) {
					listehotelfinale.add(h);
				}
			}	
		}
		return listehotelfinale;
	}
	
	
	public boolean verifierDate(chambre chambre, LocalDate Departure, LocalDate Arrival) {
		if (Arrival.isBefore(Departure) && Arrival.isAfter(LocalDate.now())) {
			
			if (chambre.getArrivals().isEmpty()) { return true;}
			else {
				for (int i = 0; i < chambre.getArrivals().size(); i++ ) {
					if (Departure.isAfter(Arrival)							
						&& Departure.isBefore(chambre.getArrivals().get(i)) || Arrival.isAfter(chambre.getDepartures().get(i))
						&& chambre.getArrivals().get(i).isAfter(Departure) || chambre.getDepartures().get(i).isBefore(Arrival)){
						return true;
					}
				}
			}
		}
		else {
			System.out.println(Arrival +" must be before " + Departure + " and after " +LocalDate.now());
		}
	return false;
}


}
