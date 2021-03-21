/**
 * 
 */
package com.spring.boot.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.productservice.constants.RestConstants;
import com.spring.boot.productservice.dto.Product;
import com.spring.boot.productservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mayankjain02
 *
 */
@RestController
@RequestMapping(value = RestConstants.BASE_URL)
@Slf4j
public class ProductController {
	
	private ProductService productServcie;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productServcie = productService;
	}
	 
	@PostMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
		
		productServcie.addProduct(product);
		log.info("----Product added successfully----");
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products = productServcie.getAllProducts();
		log.info("----Products Fetched Successfully----");
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping(value="/products/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
		
		List<Product> products = productServcie.getProductsByCategory(category);
		log.info("----Products Fetched Successfully By Category----");
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping(value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable String id){
		
		Product product = productServcie.getProductById(id);
		log.info("----Product with id, {} is fetched successfully", id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String id){
		
		productServcie.deleteProductById(id);
		log.info("----Product with id, {} is deleted successfully", id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
