package com.mycompany.collectorvault.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name ="coleccion")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Coleccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coleccionid")
	private int coleccionId;
	
	@Column(name="nombre_col")
	private String nombreCol;
	
	@Column(name="valor")
	private int valor;

	@Column(name="numero_articulos")
	private int numeroArticulos;
	
	//ojo con la fecha, no vaya a dar problemas
	@Column(name="fecha_apertura")
	private Date fechaApertura;
	
	@Column(name="usuarioid")
	private int usuarioid;
	
	
	/*@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="plataformaId")
	private Plataforma plataforma;*/
	
	@Column(name="plataformaid")
	private int plataforma;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade = CascadeType.REFRESH)
	@JoinTable(
			name="coleccion_item",
			joinColumns=@JoinColumn(name = "coleccionid"),
			inverseJoinColumns=@JoinColumn(name = "itemid")
			)
	private List<Item> itemsDeLaColeccion;


	public Coleccion(int coleccionId, String nombreCol, int valor, int numeroArticulos, Date fechaApertura,
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

	public Coleccion(String nombreCol, int valor, int numeroArticulos, Date fechaApertura,
			int usuario) {
		this.nombreCol = nombreCol;
		this.valor = valor;
		this.numeroArticulos = numeroArticulos;
		this.fechaApertura = fechaApertura;
		this.usuarioid = usuario;
		}

	public Coleccion() {
	}

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
	
	public int getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}
	


	@Override
	public String toString() {
		return "Coleccion [coleccionId=" + coleccionId + ", nombreCol=" + nombreCol + ", valor=" + valor
				+ ", numeroArticulos=" + numeroArticulos + ", fechaApertura=" + fechaApertura + "]";
	}

	public int getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}

	public List<Item> getItemsDeLaColeccion() {
		return itemsDeLaColeccion;
	}

	public void setItemsDeLaColeccion(List<Item> itemsDeLaColeccion) {
		this.itemsDeLaColeccion = itemsDeLaColeccion;
	}
	
	public void addItemsDeLaColeccion(Item item) {
		this.itemsDeLaColeccion.add(item);
	}
	

}
