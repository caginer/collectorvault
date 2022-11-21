package com.mycompany.collectorvault.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="plataforma")
public class Plataforma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plataformaid")
	private int plataformaId;
	
	@Column(name="nombre")
	private String nombrePlataforma;
	
	@Column(name="numero_articulos_plat")
	private int numeroArticulosPLataforma;
	
	@Column(name="valor")
	private int valorPlataforma;
	
	@Column(name="plataformaimagen")
	private String plataformaImagen;
	
	/*@JsonIgnore
	@OneToOne (mappedBy="plataforma", cascade = CascadeType.ALL)
    private Coleccion coleccion;*/
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="plataformaid")
	private List<Item> itemsPlataforma;
	
	

	public Plataforma(String nombrePlataforma, int numeroArticulosPLataforma, int valorPlataforma,
			List<Item> itemsPlataforma) {
		this.nombrePlataforma = nombrePlataforma;
		this.numeroArticulosPLataforma = numeroArticulosPLataforma;
		this.valorPlataforma = valorPlataforma;
		this.itemsPlataforma = itemsPlataforma;
	}

	public Plataforma() {
	}

	public int getPlataformaId() {
		return plataformaId;
	}

	public void setPlataformaId(int plataformaId) {
		this.plataformaId = plataformaId;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	public int getNumeroArticulosPLataforma() {
		return numeroArticulosPLataforma;
	}

	public void setNumeroArticulosPLataforma(int numeroArticulosPLataforma) {
		this.numeroArticulosPLataforma = numeroArticulosPLataforma;
	}

	public int getValorPlataforma() {
		return valorPlataforma;
	}

	public void setValorPlataforma(int valorPlataforma) {
		this.valorPlataforma = valorPlataforma;
	} 
	
	public String getPlataformaImagen() {
		return plataformaImagen;
	}

	public void setPlataformaImagen(String plataformaImagen) {
		this.plataformaImagen = plataformaImagen;
	}

	public List<Item> getItemsPlataforma() {
		return itemsPlataforma;
	}

	public void setItemsPlataforma(List<Item> itemsPlataforma) {
		this.itemsPlataforma = itemsPlataforma;
	}
	
	

	@Override
	public String toString() {
		return "Plataforma [plataformaId=" + plataformaId + ", nombrePlataforma=" + nombrePlataforma
				+ ", numeroArticulosPLataforma=" + numeroArticulosPLataforma + ", valorPlataforma=" + valorPlataforma
				+ ", itemsPlataforma=" + itemsPlataforma + "]";
	}
	
	
	
	

}
