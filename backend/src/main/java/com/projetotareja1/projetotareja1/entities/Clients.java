package com.projetotareja1.projetotareja1.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="tb_clients")
public class Clients  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;
	
	
	public Clients() {
		
	}


	public Clients(Long id, String name,String cpf, Double income, Instant birthDate, Integer children) {
		
		this.id = id;
		this.name = name;
		this.cpf=cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	
	
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCpf() {
		return cpf;
	}


	public void setCpfe(String cpf) {
		this.cpf = cpf;
	}


	public Double getIncome() {
		return income;
	}


	public void setIncome(Double income) {
		this.income = income;
	}


	public Instant getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}


	public Integer getChildren() {
		return children;
	}


	public void setChildren(Integer children) {
		this.children = children;
	}



	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
