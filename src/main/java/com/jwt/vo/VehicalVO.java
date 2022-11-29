package com.jwt.vo;

import lombok.Data;

@Data
public class VehicalVO {
	
	private String vehicalNo ;
	private String vehicalType ;
	private int lengthOfVehical ;
	private String vehicalName ;
	private String vehicalOwnerName ;
	private String vehicalExpireDate ;
    private DriverVO driverVO ;
}
