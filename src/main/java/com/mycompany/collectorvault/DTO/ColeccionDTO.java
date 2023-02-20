package com.mycompany.collectorvault.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mycompany.collectorvault.entity.Item;

public class ColeccionDTO {
	

	private int coleccionId;
	
	@NotEmpty
	@Size(min = 4, message = "El título de la publicación debe de tener mas de 4 caracteres")
	private String nombreCol;
	
	private int valor;
	private int numeroArticulos;
	
	@NotNull
	private Date fechaApertura;
	
	
	private String username;
	
	@NotNull
	private int plataforma;
	private List<Item> itemsDeLaColeccion;
	
	public int getColeccionId() {
		return coleccionId;
	}

	public void setColeccionId(int coleccionId) {
		this.coleccionId = coleccionId;
	}

	public String getNombreCol() {
		return nombreCol;
	}

	public void setNombreCol(String nombreCol) {
		this.nombreCol = nombreCol;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getNumeroArticulos() {
		return numeroArticulos;
	}

	public void setNumeroArticulos(int numeroArticulos) {
		this.numeroArticulos = numeroArticulos;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}

	public List<Item> getItemsDeLaColeccion() {
		return itemsDeLaColeccion;
	}

	public void setItemsDeLaColeccion(List<Item> itemsDeLaColeccion) {
		this.itemsDeLaColeccion = itemsDeLaColeccion;
	}

	public ColeccionDTO() {
	}

	public ColeccionDTO(int coleccionId, String nombreCol, int valor, int numeroArticulos, Date fechaApertura,
			String username, int plataforma, List<Item> itemsDeLaColeccion) {
		this.coleccionId = coleccionId;
		this.nombreCol = nombreCol;
		this.valor = valor;
		this.numeroArticulos = numeroArticulos;
		this.fechaApertura = fechaApertura;
		this.username = username;
		this.plataforma = plataforma;
		this.itemsDeLaColeccion = itemsDeLaColeccion;
	}


}
