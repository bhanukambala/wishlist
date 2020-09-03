package com.dxctraining.product.util;

import org.springframework.stereotype.Component;

import com.dxctraining.product.dto.ProductDto;
import com.dxctraining.product.entities.Product;

@Component
	public class ProductUtil {

		public ProductDto productDto(Product product) {
			ProductDto dto = new ProductDto(product.getId(), product.getName());
			return dto;
		}
}
