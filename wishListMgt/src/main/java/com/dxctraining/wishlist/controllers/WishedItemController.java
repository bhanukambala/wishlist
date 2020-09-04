package com.dxctraining.wishlist.controllers;

import com.dxctraining.wishlist.dto.CreateWishedItemRequest;
import com.dxctraining.wishlist.dto.CustomerDto;
import com.dxctraining.wishlist.dto.ProductDto;
import com.dxctraining.wishlist.dto.WishedItemDto;
import com.dxctraining.wishlist.entities.WishedItem;
import com.dxctraining.wishlist.service.IWishedItemService;
import com.dxctraining.wishlist.util.WishedItemUtil;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wisheditems")
public class WishedItemController {

	@Autowired
	private IWishedItemService service;

	@Autowired
	private WishedItemUtil util;
	
	@Autowired
	private RestTemplate restTemplate;


	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public WishedItemDto create(@RequestBody CreateWishedItemRequest requestData) {
		String productId = requestData.getProductId();
		Integer customerId=requestData.getCustomerId();
		WishedItem wisheditem = new WishedItem(productId,customerId);
		wisheditem = service.add(wisheditem);
		ProductDto productDto = fetchWishedItemsByProduct(productId);
		CustomerDto customerDto=fetchWishedItemByCustomer(customerId);
		WishedItemDto response = util.wishedItemDto(wisheditem, customerId, productId);
		return response;
	}

	private CustomerDto fetchWishedItemByCustomer(Integer customerId) {
		String url="http://customerMgt/customers/get/"+customerId;
		CustomerDto dto=restTemplate.getForObject(url,CustomerDto.class);
		return dto;
		}

	private ProductDto fetchWishedItemsByProduct(String productId) {
		String url = "http://productMgt/products/get/" + productId;
		ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
		return dto;
		}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<WishedItemDto> findAllById(@PathVariable("customerId")Integer customerId) {
		List<WishedItem>list = service.findAllById(customerId);
		List<WishedItemDto>response = new ArrayList<>();
		for (WishedItem wishedItem : list) {
			String productId = wishedItem.getProductId();
        	ProductDto productDto = fetchWishedItemsByProduct(productId);
        	Integer custoId = wishedItem.getCustomerId();
        	CustomerDto customer = fetchWishedItemByCustomer(customerId);
        	WishedItemDto dto = util.wishedItemDto(wishedItem,customerId,productId);
			response.add(dto);
			}
		return response;
	}
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.CREATED)
	public List<WishedItemDto> fetchAll() {
		List<WishedItem> list = service.fetchallWishedItemsFromProducts();
		List<WishedItemDto> response = new ArrayList<>();
		for (WishedItem wishedItem : list) {
			String productId = wishedItem.getProductId();
			Integer customerId=wishedItem.getCustomerId();
			ProductDto productDto = fetchWishedItemsByProduct(productId);
			CustomerDto customerDto=fetchWishedItemByCustomer(customerId);
			WishedItemDto dto = util.wishedItemDto(wishedItem, customerId, productId);
			response.add(dto);
		}
		return response;
	}
}