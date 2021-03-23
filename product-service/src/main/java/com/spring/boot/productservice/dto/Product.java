/**
 * 
 */
package com.spring.boot.productservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Contains the fields of Product")
public class Product {
	@Id
	@ApiModelProperty("Unique Id of product, generated automatically")
	private String id;
	
	@NotNull(message = "Prdouct name should not be null")
	private String name;
	
	@NotNull(message = "Category can't be null")
	private Category category;
	private String currency;
	
	@Min(0)
	private Double price;
	
	@Min(0)
	private Double discount;
	private String discountDescription;
}
