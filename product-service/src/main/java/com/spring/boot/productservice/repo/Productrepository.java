/**
 * 
 */
package com.spring.boot.productservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.productservice.dto.Product;

/**
 * @author mayankjain02
 *
 */
@Repository
public interface Productrepository extends MongoRepository<Product, Integer>{

}
