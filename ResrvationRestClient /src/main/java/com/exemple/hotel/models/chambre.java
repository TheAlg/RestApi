package com.exemple.hotel.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class chambre {
	Long id;
	private hotel hotel;
	private String Category;
	private int NbPlace;
	private double price;
	private String image;


}
