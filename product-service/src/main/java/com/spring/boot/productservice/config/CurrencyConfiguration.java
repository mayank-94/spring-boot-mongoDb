/**
 * 
 */
package com.spring.boot.productservice.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mayank
 *
 */
@Configuration
@ConfigurationProperties(prefix = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConfiguration {
	
	private List<String> currencies;
}
