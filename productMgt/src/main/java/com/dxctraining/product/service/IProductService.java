package com.dxctraining.product.service;

import java.util.List;

import com.dxctraining.product.entities.Product;

public interface IProductService {
		Product findById(String id);
		List<Product> findByName(String name);
		Product add(Product product);
}
