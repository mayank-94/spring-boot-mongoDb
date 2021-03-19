/**
 * 
 */
package com.spring.boot.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.productservice.dto.Product;
import com.spring.boot.productservice.repo.Productrepository;

/**
 * @author mayankjain02
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private Productrepository prodRepo;
	
	@Autowired
	public ProductServiceImpl(Productrepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product getProductById() {
		return null;
	}

}
