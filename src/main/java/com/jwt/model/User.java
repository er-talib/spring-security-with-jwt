package com.jwt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private String userName ;
	private String password ;
	private Date loginDate ;
	private String role ;
}
