/**
 * 
 */
package com.spring.boot.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.productservice.constants.RestConstants;
import com.spring.boot.productservice.dto.Product;
import com.spring.boot.productservice.service.ProductService;

/**
 * @author mayankjain02
 *
 */
@RestController
@RequestMapping(value = RestConstants.BASE_URL)
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);		
	private ProductService productServcie;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productServcie = productService;
	}
	
	@PostMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		logger.info("----Product added successfully----");
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products = productServcie.getAllProducts();
		logger.info("----Products Fetched Successfully----");
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping(value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		
		Product product = productServcie.getProductById();
		logger.info("----Product with id, {} is fetched successfully", id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
}
