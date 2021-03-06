package com.dxctraining.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.product.dao.IProductDao;
import com.dxctraining.product.entities.Product;
import com.dxctraining.product.exception.*;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao dao;
	@Override
	public Product add(Product product) {
		product = dao.save(product);
		return product;
	}

	@Override
	public Product findById(String id) {
		Optional<Product> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new ProductNotFoundException("product not found for id= " + id);
		}
		Product product = optional.get();
		return product;
	}


	@Override
	public List<Product> findByName(String name) {
		List<Product> list = dao.findByName(name);
		return list;
	}
}
