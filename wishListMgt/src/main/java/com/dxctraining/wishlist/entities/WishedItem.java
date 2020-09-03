package com.dxctraining.wishlist.entities;

import javax.persistence.*;

@Entity
@Table(name = "wishedItems")
public class WishedItem {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String productId;
	
	private Integer customerId;
	
	public WishedItem(String productId,Integer customerId) {
		this.customerId=customerId;
		this.productId=productId;
		
	}
	public WishedItem() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Override
	    public int hashCode() {
	        return id;
	    }

	  @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        WishedItem that = (WishedItem) obj;
	        return id == that.id;
	    }
}
