package com.projetotareja1.projetotareja1.dto;

import java.io.Serializable;
import java.time.Instant;

import com.projetotareja1.projetotareja1.entities.Clients;



public class ClientsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
  
	private Long id;
	private String name;
	private  String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;
	
	
	public ClientsDTO() {
		
	}


	public ClientsDTO(Long id, String name,String cpf, Double income, Instant birthDate, Integer children) {
		
		this.id = id;
		this.name = name;
		this.cpf=cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	
	
	public ClientsDTO(Clients entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf=entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();
			
		
	}


	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}


	public void setCpfe(String cpf) {
		this.cpf = cpf;
	}



	public void setName(String name) {
		this.name = name;
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
	
	
	
	
	

}
