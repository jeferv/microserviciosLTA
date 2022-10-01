package com.carro.service.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String marca;
	private String modelo;
	private Integer usuarioId;
	
	
	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Carro(Integer id, String marca, String modelo, Integer usuarioId) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}	
	
	
	
}
