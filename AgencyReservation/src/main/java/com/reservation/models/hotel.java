package com.reservation.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class hotel {

	private long id;	
	private String name;
	private adress adress;
	private int Stars;
	private List <chambre> ListeChambre ;

	
	




	
	
	

	

	
	
	

}
