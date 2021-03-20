/**
 * 
 */
package com.spring.boot.productservice.service;

import java.util.List;

import com.spring.boot.productservice.dto.Product;

/**
 * @author mayankjain02
 *
 */
public interface ProductService {
	
	List<Product> getAllProducts();
	Product getProductById(Integer id);
	void addProduct(Product product);
	List<Product> getProductsByCategory(String category);
	void deleteProductById(Integer id);
}
