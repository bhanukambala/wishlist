package com.dxctraining.wishlist.dto;

public class CreateWishedItemRequest {

	private String productId;
	private Integer customerId;
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

	
}
