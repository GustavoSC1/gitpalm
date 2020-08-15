package com.gustavo.gitpalm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gustavo.gitpalm.api.ApiBinding;
import com.gustavo.gitpalm.dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private ApiBinding apiBinding;
	
	public ResponseEntity<UserDTO> getAuthenticatedUser(){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.github.com")
				.path("/user")
				.build();
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, UserDTO.class);
	}
	
	public ResponseEntity<UserDTO> getAUser(String username){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.github.com")
				.path("/users/"+username)
				.build();
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, UserDTO.class);
	}
	

}
