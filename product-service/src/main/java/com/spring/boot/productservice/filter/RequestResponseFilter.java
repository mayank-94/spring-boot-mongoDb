/**
 * 
 */
package com.spring.boot.productservice.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mayankjain02
 *
 */
@Slf4j
@Component
public class RequestResponseFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		CustomHttpRequestWrapper httpRequest = new CustomHttpRequestWrapper((HttpServletRequest) request);
		log.info("----Request URI, {}" , httpRequest.getRequestURI());
		log.info("----Request Method, {}", httpRequest.getMethod());
		log.info("----Request Body, {}", new String(httpRequest.getByteArray())); //Input request will be processed 
		//after passing this filter, so we need a wrapper.
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		chain.doFilter(httpRequest, httpResponse);
		
		log.info("----Response status, {}", httpResponse.getStatus());
	}
	
	private class CustomHttpRequestWrapper extends HttpServletRequestWrapper{
		
		private byte[] byteArray;
		public CustomHttpRequestWrapper(HttpServletRequest request) {
			super(request);
			try {
				byteArray = IOUtils.toByteArray(request.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException("Issue while reading input..");
			}
		}
		
		@Override
		public ServletInputStream getInputStream() throws IOException {
			
			return new MyDelegatingServletInputStream(new ByteArrayInputStream(byteArray));
		}

		public byte[] getByteArray() {
			return byteArray;
		}
	}
}
