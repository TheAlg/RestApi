package com.reservation.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="Hotel")
@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="adress_ID",referencedColumnName="id",nullable=false,unique=false)
	private adress adress;
	
	@Column(name = "stars")
	private int Stars;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List <chambre> chambres ;
	
	@JsonBackReference
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="agency_id", nullable=false)
    private Agency agency;
	
	
	
	

	
	




	
	
	

	

	
	
	

}
