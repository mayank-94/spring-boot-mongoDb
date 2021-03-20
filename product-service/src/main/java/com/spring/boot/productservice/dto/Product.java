/**
 * 
 */
package com.spring.boot.productservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mayankjain02
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "product")
public class Product {
	@Id
	private Integer id;
	private String name;
	private Category category;
	private String currency;
	private Double price;
	private Double discount;
	private String discountDescription;
}
