/**
 * 
 */
package com.spring.boot.productservice.dto;

import io.swagger.annotations.ApiModel;
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
@ApiModel("Contains fields of Category")
public class Category {
	
	private Integer id;
	private String name;
	private String brand;
	
}
