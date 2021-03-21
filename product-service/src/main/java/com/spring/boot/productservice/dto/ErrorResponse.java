/**
 * 
 */
package com.spring.boot.productservice.dto;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mayank
 *
 */

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private List<String> errors;
	private HttpStatus httpStatus;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date timestamp;
	private Integer code;
	private String path;
}
