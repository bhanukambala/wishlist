package com.dxctraining.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.product.entities.Product;
import com.dxctraining.product.exception.InvalidArgumentException;
import com.dxctraining.product.service.IProductService;
import com.dxctraining.product.service.ProductServiceImpl;
@ExtendWith(SpringExtension.class)
@DataMongoTest
@Import(ProductServiceImpl.class)
class ProductServiceImplTest {
	
	@Autowired
	private IProductService service;	
	@Test
	public void testAdd_2() {
		String name = "phone";
		Product product = new Product(name);
		product = service.add(product);
		Product fetchedproduct = service.findById(product.getId());
		Assertions.assertEquals(product.getId(),fetchedproduct.getId());
		Assertions.assertEquals(name,fetchedproduct.getName());
	}
	@Test
	public void testFindById_2() {
		String name = "laptop";
		Product product = new Product(name);
		product = service.add(product);
		String id = product.getId();
		Product fetchedproduct = service.findById(id);
		Assertions.assertEquals(fetchedproduct.getId(), id);
	}

}