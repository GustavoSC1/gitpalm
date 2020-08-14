package com.gustavo.gitpalm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gustavo.gitpalm.api.ApiBinding;
import com.gustavo.gitpalm.dto.RepositoryDTO;

@Service
public class RepositoryService {
	
	@Autowired
	private ApiBinding apiBinding;
	
	public ResponseEntity<List<RepositoryDTO>> listUserRepository(String visibility, String affiliation, String sort, String direction){
		UriComponents uri = UriComponentsBuilder.newInstance()  
				.scheme("https")
				.host("api.github.com")
				.path("/user/repos")
				.queryParam("visibility", visibility)
				.queryParam("affiliation", affiliation)
				.queryParam("sort", sort)
				.queryParam("direction", direction)
				.build();
		
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<RepositoryDTO>>() {});
	}
	
	public ResponseEntity<List<RepositoryDTO>> listSpecifiedUserRepository(String username, String type, String sort, String direction){
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.github.com")
			.path("/users/"+username+"/repos")
			.queryParam("type", type)
			.queryParam("sort", sort)
			.queryParam("direction", direction)
			.build();
		
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<RepositoryDTO>>() {});
	}
	
	public ResponseEntity<RepositoryDTO> getRepository(String owner, String repo){
		UriComponents uri = UriComponentsBuilder.newInstance()  
				.scheme("https")
				.host("api.github.com")
				.path("/repos/"+owner+"/"+repo)
				.build();
		
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, RepositoryDTO.class);
	}
	
}
