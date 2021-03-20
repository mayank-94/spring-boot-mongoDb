/**
 * 
 */
package com.spring.boot.productservice.service;

import java.util.List;
import java.util.Optional;

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
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> product = prodRepo.findById(id);
		if(product.isPresent())
			return product.get();
		
		else
			throw new RuntimeException("Product with Id, "+id+" does not exist");
	}

	@Override
	public void addProduct(Product product) {
		prodRepo.save(product);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return prodRepo.findByCategory(category);
	}

	@Override
	public void deleteProductById(Integer id) {
		Optional<Product> product = prodRepo.findById(id);
		if(!product.isPresent())
			throw new RuntimeException("Prodcut can't be deleted");
		
		prodRepo.deleteById(id);;
	}

}
