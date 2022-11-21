package com.mycompany.collectorvault.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="historico")
public class ItemVendido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="historicoid")
	private int itemVendidoId;
	
	@Column(name="categoria")
	private String categoriaItemVendido;
	
	@Column(name ="venta")
	private int precioItemVendido;
	
	@Column(name ="fecha_venta")
	private Date fechaVenta;
	
	@Column(name ="plataforma_venta")
	private String plataformaVenta;
	
	@Column(name ="source_link")
	private String linkItemVendido;
	
	@Column(name ="fecha_subida")
	private Date fechaSubida;

	public ItemVendido(String categoriaItemVendido, int precioItemVendido, Date fechaVenta, String plataformaVenta,
			String linkItemVendido, Date fechaSubida) {
		this.categoriaItemVendido = categoriaItemVendido;
		this.precioItemVendido = precioItemVendido;
		this.fechaVenta = fechaVenta;
		this.plataformaVenta = plataformaVenta;
		this.linkItemVendido = linkItemVendido;
		this.fechaSubida = fechaSubida;
	}

	public ItemVendido() {
	}

	public int getItemVendidoId() {
		return itemVendidoId;
	}

	public void setItemVendidoId(int itemVendidoId) {
		this.itemVendidoId = itemVendidoId;
	}

	public String getCategoriaItemVendido() {
		return categoriaItemVendido;
	}

	public void setCategoriaItemVendido(String categoriaItemVendido) {
		this.categoriaItemVendido = categoriaItemVendido;
	}

	public int getPrecioItemVendido() {
		return precioItemVendido;
	}

	public void setPrecioItemVendido(int precioItemVendido) {
		this.precioItemVendido = precioItemVendido;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getPlataformaVenta() {
		return plataformaVenta;
	}

	public void setPlataformaVenta(String plataformaVenta) {
		this.plataformaVenta = plataformaVenta;
	}

	public String getLinkItemVendido() {
		return linkItemVendido;
	}

	public void setLinkItemVendido(String linkItemVendido) {
		this.linkItemVendido = linkItemVendido;
	}

	public Date getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	@Override
	public String toString() {
		return "ItemVendido [itemVendidoId=" + itemVendidoId + ", categoriaItemVendido=" + categoriaItemVendido
				+ ", precioItemVendido=" + precioItemVendido + ", fechaVenta=" + fechaVenta + ", plataformaVenta="
				+ plataformaVenta + ", linkItemVendido=" + linkItemVendido + ", fechaSubida=" + fechaSubida + "]";
	}
	
	
	


}
