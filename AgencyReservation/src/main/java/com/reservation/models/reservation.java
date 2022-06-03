package com.reservation.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class reservation {

	private long id;
	private String name;
	private String lastname;
	private LocalDate arrival;
	private LocalDate departure;
	private int cb;
	private hotel hotel_id ;
	private chambre chambre_id ;
	
	
	public reservation(int id, String name, String lastname,  int cb) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.cb = cb;
	}



}


