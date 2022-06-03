package com.reservation.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "chambre")
@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class chambre {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="hotel_id",nullable=false)
	private hotel hotel;
	
	@Column(name = "category")
	private String Category;
	
	@Column(name = "Nbplace")
	private int NbPlace;
	
	@Column(name = "Arrivals")
	@ElementCollection
	private List <LocalDate> Arrivals = new ArrayList<>();
	
	@Column(name = "Departures")
	@ElementCollection
	private List <LocalDate> Departures = new ArrayList<>() ;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "chambre_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <reservation> Reservations;
	
	@Column(name = "price")
	private double price;
	
	@Column
	private String image;



}
