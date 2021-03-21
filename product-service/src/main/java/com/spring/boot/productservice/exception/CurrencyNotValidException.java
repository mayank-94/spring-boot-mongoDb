/**
 * 
 */
package com.spring.boot.productservice.exception;

/**
 * @author Mayank
 *
 */
public class CurrencyNotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CurrencyNotValidException(String msg) {
		super(msg);
	}

}
