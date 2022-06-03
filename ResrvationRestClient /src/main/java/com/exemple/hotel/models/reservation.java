package com.exemple.hotel.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class reservation {

	private String name;
	private String lastname;
	private LocalDate arrival;
	private LocalDate departure;
	private int cb;
	private chambre chambre_id ;
	
	
	public reservation(int id, String name, String lastname,  int cb) {
		this.name = name;
		this.lastname = lastname;
		this.cb = cb;
	}


	public reservation(chambre chambre, String name, String lastName, int cb, LocalDate arrival,
			LocalDate departure) {
		this.chambre_id = chambre;
		this.name = name;
		this.lastname = lastName;
		this.cb = cb;
		this.arrival = arrival;
		this.departure = departure;
		
	}



}


