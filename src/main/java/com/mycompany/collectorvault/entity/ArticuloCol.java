package com.mycompany.collectorvault.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="misarticulos")
public class ArticuloCol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="misarticulosid")
	private int ArticuloColId;
	
	@Column(name="estado")
	private String estado;

	@Column(name="fecha_registro")
	private Date FechaRegistro;

	@Column(name="fecha_compra")
	private Date FechaCompra;

	@Column(name="instrucciones")
	private Boolean instrucciones;
	
	@Column(name="estado_instrucciones")
	private String estadoInstrucciones;
	
	@Column(name="caja")
	private Boolean caja;
	
	@Column(name="estado_caja")
	private String estadoCaja;
	
	@Column(name="soporte")
	private Boolean soporte;
	
	@Column(name="estado_soporte")
	private String estadoSoporte;
	
	@OneToOne()
	@JoinColumn(name="itemid")
	private Item item;
	
	//pruebas de hibernate
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coleccionId")
    private Coleccion coleccion;

	public ArticuloCol() {
	}

	public ArticuloCol(String estado, Date fechaRegistro, Date fechaCompra, Boolean instrucciones,
			String estadoInstrucciones, Boolean caja, String estadoCaja, Boolean soporte, String estadoSoporte,
			Item item) {
		this.estado = estado;
		FechaRegistro = fechaRegistro;
		FechaCompra = fechaCompra;
		this.instrucciones = instrucciones;
		this.estadoInstrucciones = estadoInstrucciones;
		this.caja = caja;
		this.estadoCaja = estadoCaja;
		this.soporte = soporte;
		this.estadoSoporte = estadoSoporte;
		this.item = item;
	}

	public int getArticuloColId() {
		return ArticuloColId;
	}

	public void setArticuloColId(int articuloColId) {
		ArticuloColId = articuloColId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public Date getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public Boolean getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(Boolean instrucciones) {
		this.instrucciones = instrucciones;
	}

	public String getEstadoInstrucciones() {
		return estadoInstrucciones;
	}

	public void setEstadoInstrucciones(String estadoInstrucciones) {
		this.estadoInstrucciones = estadoInstrucciones;
	}

	public Boolean getCaja() {
		return caja;
	}

	public void setCaja(Boolean caja) {
		this.caja = caja;
	}

	public String getEstadoCaja() {
		return estadoCaja;
	}

	public void setEstadoCaja(String estadoCaja) {
		this.estadoCaja = estadoCaja;
	}

	public Boolean getSoporte() {
		return soporte;
	}

	public void setSoporte(Boolean soporte) {
		this.soporte = soporte;
	}

	public String getEstadoSoporte() {
		return estadoSoporte;
	}

	public void setEstadoSoporte(String estadoSoporte) {
		this.estadoSoporte = estadoSoporte;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ArticuloCol [ArticuloColId=" + ArticuloColId + ", estado=" + estado + ", FechaRegistro=" + FechaRegistro
				+ ", FechaCompra=" + FechaCompra + ", instrucciones=" + instrucciones + ", estadoInstrucciones="
				+ estadoInstrucciones + ", caja=" + caja + ", estadoCaja=" + estadoCaja + ", soporte=" + soporte
				+ ", estadoSoporte=" + estadoSoporte + ", item=" + item + "]";
	}
	
	

}
