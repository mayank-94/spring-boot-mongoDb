/**
 * 
 */
package com.spring.boot.productservice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.productservice.filter.RequestResponseFilter;

/**
 * @author mayankjain02
 *
 */
@Configuration
public class FilterConfiguration {
	
	@Bean
	public FilterRegistrationBean<RequestResponseFilter> createLoggers(RequestResponseFilter requestResponseFilter){
		FilterRegistrationBean<RequestResponseFilter> registrationBean = 
				new FilterRegistrationBean<RequestResponseFilter>();
		
		registrationBean.setFilter(requestResponseFilter);
		registrationBean.addUrlPatterns("/api/v1/products"); //logging these URIs only
		
		return registrationBean;
	}
	
}
