package com.exemple.hotel.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Offre {

	private Long agence_id;
	private Long chambre_id ;
	private int OffreReference ;
	private String ReservationReference;
	private LocalDate arrival ;
	private LocalDate departure ;
	private String Name;
	private String LastName;
	private int cb;
	

}
