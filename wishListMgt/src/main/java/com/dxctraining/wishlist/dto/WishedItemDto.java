package com.dxctraining.wishlist.dto;

public class WishedItemDto {
	private Integer id;
	private String productId;
	private Integer customerId; 

	public WishedItemDto(Integer id, String productId,Integer customerId) {
		this.id = id;
		this.customerId=customerId;
		this.productId=productId;
	}
	public WishedItemDto() {
		
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

	public void setId(Integer id) {
		this.id = id;
	}

}
