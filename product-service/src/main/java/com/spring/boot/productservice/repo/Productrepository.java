/**
 * 
 */
package com.spring.boot.productservice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.productservice.dto.Product;

/**
 * @author mayankjain02
 *
 */
@Repository
public interface Productrepository extends MongoRepository<Product, String>{
	
	@Query("{'Category.name':?0}")
	List<Product> findByCategory(String category);
}
