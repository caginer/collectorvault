package com.mycompany.collectorvault.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="mercado")
public class ItemEnVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemEnVentaId")
	private int itemEnVentaId;
	
	@Column(name="categoria")
	private String categoriaItemEnVenta;
	
	@Column(name="precio_actual")
	private int precioActual;
	
	@Column(name="subasta")
	private boolean subasta;
	
	@Column(name="fecha_subida")
	private Date fechaSubida;
	
	@Column(name="plataforma_venta")
	private String plataformaVenta;
	
	@Column(name ="source_link")
	private String linkItemVendido;

	public ItemEnVenta(String categoriaItemEnVenta, int precioActual, boolean subasta, Date fechaSubida,
			String plataformaVenta, String linkItemVendido) {
		this.categoriaItemEnVenta = categoriaItemEnVenta;
		this.precioActual = precioActual;
		this.subasta = subasta;
		this.fechaSubida = fechaSubida;
		this.plataformaVenta = plataformaVenta;
		this.linkItemVendido = linkItemVendido;
	}

	public ItemEnVenta() {
	}

	public int getItemEnVentaId() {
		return itemEnVentaId;
	}

	public void setItemEnVentaId(int itemEnVentaId) {
		this.itemEnVentaId = itemEnVentaId;
	}

	public String getCategoriaItemEnVenta() {
		return categoriaItemEnVenta;
	}

	public void setCategoriaItemEnVenta(String categoriaItemEnVenta) {
		this.categoriaItemEnVenta = categoriaItemEnVenta;
	}

	public int getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(int precioActual) {
		this.precioActual = precioActual;
	}

	public boolean isSubasta() {
		return subasta;
	}

	public void setSubasta(boolean subasta) {
		this.subasta = subasta;
	}

	public Date getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
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

	@Override
	public String toString() {
		return "ItemEnVenta [itemEnVentaId=" + itemEnVentaId + ", categoriaItemEnVenta=" + categoriaItemEnVenta
				+ ", precioActual=" + precioActual + ", subasta=" + subasta + ", fechaSubida=" + fechaSubida
				+ ", plataformaVenta=" + plataformaVenta + ", linkItemVendido=" + linkItemVendido + "]";
	}
	
	
	
	
	

}
