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
	Product getProductById();
}
