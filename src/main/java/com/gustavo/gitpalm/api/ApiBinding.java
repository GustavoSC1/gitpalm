package com.gustavo.gitpalm.api;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public class ApiBinding {
	
	protected RestTemplate restTemplate;
			
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public ApiBinding(String accessToken) {
		this.restTemplate = new RestTemplate();
		if (accessToken != null) {
			this.restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
		} else {
			this.restTemplate.getInterceptors().add(getNoTokenInterceptor());
		}
	}
	//A request interceptor is created for the to ensure that the given access token is included in all requests to the API.
	private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
				request.getHeaders().add("Content-Type", "application/json");
				request.getHeaders().add("ACCEPT", "application/vnd.github.nebula-preview+json");
				request.getHeaders().add("Authorization", "Bearer  " + accessToken);	
				return execution.execute(request, bytes);
			}
		};
	}
	
	//If the given access token is null, a special request interceptor will throw an IllegalStateException without even trying to make the API request. 
	private ClientHttpRequestInterceptor getNoTokenInterceptor() {
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
				throw new IllegalStateException("Can't access the GitHub API without an access token");
			}
		};
	}

}
