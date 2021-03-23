/**
 * 
 */
package com.spring.boot.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.productservice.config.CurrencyConfiguration;
import com.spring.boot.productservice.dto.Product;
import com.spring.boot.productservice.exception.CurrencyNotValidException;
import com.spring.boot.productservice.exception.OfferNotValidException;
import com.spring.boot.productservice.exception.ProductNotFoundException;
import com.spring.boot.productservice.repo.Productrepository;

/**
 * @author mayankjain02
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private final Productrepository prodRepo;
	private final CurrencyConfiguration currencyConfiguration;
	
	@Autowired
	public ProductServiceImpl(Productrepository prodRepo, CurrencyConfiguration currencyConfiguration) {
		this.prodRepo = prodRepo;
		this.currencyConfiguration = currencyConfiguration;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(String id) {
		Optional<Product> product = prodRepo.findById(id);
		if(product.isPresent())
			return product.get();
		
		else
			throw new ProductNotFoundException("Product with Id, "+id+" does not exist");
	}

	@Override
	public void addProduct(Product product) {
		if(product.getPrice() == 0 && product.getDiscount() > 0)
			throw new OfferNotValidException("Offer is Not valid!");
		
		List<String> currencies = currencyConfiguration.getCurrencies();
		if(!currencies.contains(product.getCurrency().toUpperCase()))
			throw new CurrencyNotValidException("Invalid Currency");
		
		prodRepo.save(product);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return prodRepo.findByCategory(category);
	}

	@Override
	public void deleteProductById(String id) {
		Optional<Product> product = prodRepo.findById(id);
		if(!product.isPresent())
			throw new RuntimeException("Prodcut can't be deleted");
		
		prodRepo.deleteById(id);;
	}

}
