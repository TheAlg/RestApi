package com.exemple.hotel.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Agency {

	private Long id ;
	private String name;
	private String description;
	private List<hotel> hotels;
	
}
