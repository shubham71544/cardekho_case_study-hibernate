package com.jspiders.cardekho_case_study_hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	private int carId;
	private String carName;
	private String carMod;
	private String fuelt;
	private double price;
	
	
}