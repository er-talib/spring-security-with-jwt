package com.jwt.co;

import com.jwt.entities.Driver;

import lombok.Data;

@Data
public class VehicalCO {
	
	private String vehicalNo ;
	private String vehicalType ;
	private int lengthOfVehical ;
	private String vehicalName ;
	private String vehicalOwnerName ;
	private String vehicalExpireDate ;
	
	private DriverCO driverCO ;


}
