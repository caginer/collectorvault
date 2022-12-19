package com.mycompany.collectorvault.DTO;

import java.util.Date;
import java.util.List;


import com.mycompany.collectorvault.entity.Item;

public class ColeccionDTO {
	

	private int coleccionId;
	private String nombreCol;
	private int valor;
	private int numeroArticulos;
	private Date fechaApertura;
	private int usuarioid;
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

	public int getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
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
			int usuarioid, int plataforma, List<Item> itemsDeLaColeccion) {
		this.coleccionId = coleccionId;
		this.nombreCol = nombreCol;
		this.valor = valor;
		this.numeroArticulos = numeroArticulos;
		this.fechaApertura = fechaApertura;
		this.usuarioid = usuarioid;
		this.plataforma = plataforma;
		this.itemsDeLaColeccion = itemsDeLaColeccion;
	}


}
