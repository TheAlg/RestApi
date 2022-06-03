package com.reservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Adress")
@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class adress {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


	@Column(name = "country")
	private String Country;
	@Column(name = "city")
	private String city;
	@Column(name = "StreetName")
	private String Street;
	@Column(name = "StreetNumber")
	private int StreetNumber;
	@Column(name = "GPS")
	private String GPS;
	

	
}
