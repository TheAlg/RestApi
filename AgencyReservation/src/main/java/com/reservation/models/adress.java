package com.reservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class adress {
    private long id;
	private String Country;
	private String city;
	private String Street;
	private int StreetNumber;
	private String GPS;

	
}
