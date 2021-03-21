/**
 * 
 */
package com.spring.boot.productservice.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.boot.productservice.dto.ErrorResponse;

/**
 * @author Mayank
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> productNotFoundValidHandler(Exception ex, ServletWebRequest request){
		
		ErrorResponse response = ErrorResponse.builder()
				.httpStatus(HttpStatus.NOT_FOUND)
				.code(HttpStatus.NOT_FOUND.value())
				.path(request.getDescription(true))
				.timestamp(new Date())
				.errors(Arrays.asList(ex.getMessage()))
				.build();
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({OfferNotValidException.class, CurrencyNotValidException.class})
	public ResponseEntity<ErrorResponse> offerNotValidHandler(Exception ex, ServletWebRequest request){
		
		ErrorResponse response = ErrorResponse.builder()
				.httpStatus(HttpStatus.BAD_REQUEST)
				.code(HttpStatus.BAD_REQUEST.value())
				.path(request.getDescription(true))
				.timestamp(new Date())
				.errors(Arrays.asList(ex.getMessage()))
				.build();
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		List<String> exception = fieldErrors.stream().map(err -> err.getField() + " : " + err.getDefaultMessage())
			.collect(Collectors.toList());
		
		ErrorResponse response = ErrorResponse.builder()
				.httpStatus(HttpStatus.BAD_REQUEST)
				.code(HttpStatus.BAD_REQUEST.value())
				.path(request.getDescription(true))
				.timestamp(new Date())
				.errors(exception)
				.build();
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
}
