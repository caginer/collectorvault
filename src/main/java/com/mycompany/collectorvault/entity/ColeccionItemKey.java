package com.mycompany.collectorvault.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColeccionItemKey implements Serializable {
	

	    @Column(name = "coleccionid")
	    int coleccionId;

	    @Column(name = "itemid")
	    int itemId;
	    
	    public ColeccionItemKey(
	            int coleccionId,
	            int itemId) {
	            this.coleccionId = coleccionId;
	            this.itemId = itemId;
	        }
	    
	    public ColeccionItemKey() {
	        }
	    

		public int getColeccionId() {
			return coleccionId;
		}

		public void setColeccionId(int coleccionId) {
			this.coleccionId = coleccionId;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		
		   @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		 
		        if (o == null || getClass() != o.getClass())
		            return false;
		 
		        ColeccionItemKey that = (ColeccionItemKey) o;
		        return Objects.equals(coleccionId, that.coleccionId) &&
		               Objects.equals(itemId, that.itemId);
		    }
		 
		    @Override
		    public int hashCode() {
		        return Objects.hash(coleccionId, itemId);
		    }


}