/**
 * 
 */
package com.spring.boot.productservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mayankjain02
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.spring.boot.productservice"))
				.build()
				.apiInfo(getApinfo());
	}
	
	private ApiInfo getApinfo() {
		return new ApiInfo("Product Service", 
				"Product Service for Online Shopping", "1.0", "Terms Of Service", 
				new Contact("Mayank Jain", "www.github.com/mayank-94", "mayankjain123450@gmail.com"), 
				"Terms of Use Licence", "",
				Collections.emptyList());
	}
}
