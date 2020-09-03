package com.dxctraining.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.wishlist.dao.IWishedItemDao;
import com.dxctraining.wishlist.entities.WishedItem;
import com.dxctraining.wishlist.exception.InvalidArgumentException;

import java.util.List;

@Transactional
@Service
public class WishedItemServiceImpl implements IWishedItemService {

	@Autowired
	IWishedItemDao dao;

	@Override
	public WishedItem add(WishedItem wisheditem) {
		validate(wisheditem);
		wisheditem = dao.save(wisheditem);
		return wisheditem;
	}

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public List<WishedItem> findAllById(Integer customerId) {
		validate(customerId);
		List<WishedItem> list = dao.findByCustomerProducts(customerId);
		return list;
	}

	@Override
	public List<WishedItem> fetchallWishedItemsFromProducts() {
		List<WishedItem> list = dao.findAll();
		return list;
	}

}
