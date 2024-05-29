package com.pet.clinic.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "petdata")
public class Pet {
	@Id
	private String id;
	private String slotid;
	private String datetime;
	private String duration;
	private String servicetype;
	private String staff;
	private String status;
	private String clientid;
	private String clientname;
	private String phone;
	private String email;
	private String petid;
	private String petname;
	private String petage;
	private String medicalhistory;
	private String microchip;
	private String paymentmethod;
	private String reason;
	
	
}
