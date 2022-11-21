package com.mycompany.collectorvault.entity;

import java.util.HashSet;
import java.util.List;
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

@Entity
@Table(name="item")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemid")
	private int itemId;
	
	@Column(name ="nombre")
	private String nombreItem;
	
	@Column(name ="region")
	private String region;
	
	@Column(name ="descripcion")
	private String descripcionItem;
	
	@Column(name ="developer")
	private String developer;
	
	@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="plataformaid")
	private Plataforma plataforma;
	
	@ManyToMany(fetch=FetchType.EAGER
			)
	@JoinTable(
			name="coleccion_item",
			joinColumns=@JoinColumn(name = "itemid"),
			inverseJoinColumns=@JoinColumn(name = "coleccionid")
			)
	private Set<Coleccion> itemPertenece = new HashSet<Coleccion>(); 
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="historicoid")
	private List<ItemVendido> itemsvendidos;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="mercadoid")
	private List<ItemEnVenta> itemsEnVenta;

	public Item(String nombreItem, String region, String descripcionItem, String developer,
			List<ItemVendido> itemsvendidos, List<ItemEnVenta> itemsEnVenta) {
		this.nombreItem = nombreItem;
		this.region = region;
		this.descripcionItem = descripcionItem;
		this.developer = developer;
		this.itemsvendidos = itemsvendidos;
		this.itemsEnVenta = itemsEnVenta;
	}

	public Item() {
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescripcionItem() {
		return descripcionItem;
	}

	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public List<ItemVendido> getItemsvendidos() {
		return itemsvendidos;
	}

	public void setItemsvendidos(List<ItemVendido> itemsvendidos) {
		this.itemsvendidos = itemsvendidos;
	}

	public List<ItemEnVenta> getItemsEnVenta() {
		return itemsEnVenta;
	}

	public void setItemsEnVenta(List<ItemEnVenta> itemsEnVenta) {
		this.itemsEnVenta = itemsEnVenta;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", nombreItem=" + nombreItem + ", region=" + region + ", descripcionItem="
				+ descripcionItem + ", developer=" + developer + ", itemsvendidos=" + itemsvendidos + ", itemsEnVenta="
				+ itemsEnVenta + "]";
	}
	
	

}
