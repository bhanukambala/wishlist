package com.dxctraining.wishlist.service;

import java.util.List;

import com.dxctraining.wishlist.entities.WishedItem;

public interface IWishedItemService {
	List<WishedItem> findAllById(Integer customerId);
	List<WishedItem> fetchallWishedItemsFromProducts();
	WishedItem add(WishedItem wisheditem);
	
}
