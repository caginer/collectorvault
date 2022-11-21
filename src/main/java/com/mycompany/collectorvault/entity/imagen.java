package com.mycompany.collectorvault.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="imagenes")
public class imagen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imagenid")
	private int imagenId;
	
	@Column(name="imagelink")
	private String imageLink;
	
	@Column(name="itemId")
	private int itemid;

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	@Override
	public String toString() {
		return "imagen [imageLink=" + imageLink + ", itemid=" + itemid + "]";
	}
	

}
