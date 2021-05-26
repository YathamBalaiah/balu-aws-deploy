package com.ypa.reactjsex.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

import lombok.Data;

import lombok.Data;

@Entity
@Table(name = "lic_customer")
@Data
public class PolicyBean implements Serializable {

	public static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serial_number;
	private Integer policy_Number;
	private String customer_Name;
	private String father_Name;
	private String nominee_Name;
	private int policy_Amount;
	private String email_Id;
	private String dateof_Birth;
	private String dateof_Joining;

	
}
