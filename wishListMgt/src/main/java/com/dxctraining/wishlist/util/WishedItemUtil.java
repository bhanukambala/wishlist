package com.dxctraining.wishlist.util;

import org.springframework.stereotype.Component;

import com.dxctraining.wishlist.dto.WishedItemDto;
import com.dxctraining.wishlist.entities.WishedItem;

@Component
public class WishedItemUtil {
	public WishedItemDto wishedItemDto(WishedItem wisheditem,Integer customerId,String productId) {
		WishedItemDto dto = new WishedItemDto(wisheditem.getId(), wisheditem.getProductId(),wisheditem.getCustomerId());
		return dto;
	}
}
