package com.reservation.models;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="reservations")
@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String lastname;
	
	@Column
	private LocalDate arrival;
	
	@Column
	private LocalDate departure;
	
	@Column
	private int cb;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="chambre_id",nullable=false )
	private chambre chambre_id;
	
	@Column
	private String reference;
	
	
	
	public reservation(Long id, String name, String lastname,  int cb) {
		this.id = id;
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


