/**
 * 
 */
package com.spring.boot.productservice.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mayankjain02
 *
 */
@Configuration
public class ActuatorConfig {
	
	@Bean
	public HttpTraceRepository traceRepo() {
		return new InMemoryHttpTraceRepository();
	}
}
