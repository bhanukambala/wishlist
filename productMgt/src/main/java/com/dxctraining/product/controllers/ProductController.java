package com.dxctraining.product.controllers;

import com.dxctraining.product.dto.CreateProductRequest;
import com.dxctraining.product.dto.ProductDto;
import com.dxctraining.product.entities.Product;
import com.dxctraining.product.service.IProductService;
import com.dxctraining.product.util.ProductUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
	private IProductService service;
	
	@Autowired
	private ProductUtil util;

	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody CreateProductRequest requestData) {
		Product product=new Product();
		product.setName(requestData.getName());
		product = service.add(product);
		ProductDto response =util.productDto(product);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto findSupplierBy(@PathVariable("id") String id) {
		Product product = service.findById(id);
		ProductDto req = util.productDto(product);
		return req;
	}

}
