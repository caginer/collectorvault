package com.mycompany.collectorvault.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "rolid")
	private long rolId;

	@Column(length = 60)
	private String nombre;

	public Rol() {
		super();
	}

	public long getId() {
		return rolId;
	}

	public void setId(long id) {
		this.rolId = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
