package com.jwt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Vehical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicalId ;
	private String vehicalNo ;
	private String vehicalType ;
	private int lengthOfVehical ;
	private String vehicalName ;
	private String vehicalOwnerName ;
	private String vehicalExpireDate ;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vehical")
	private Driver driver ;

}
