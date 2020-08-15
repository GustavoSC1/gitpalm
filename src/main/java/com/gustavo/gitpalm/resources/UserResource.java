package com.gustavo.gitpalm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.gitpalm.dto.UserDTO;
import com.gustavo.gitpalm.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/authenticated", produces = "application/json")
	public ResponseEntity<UserDTO> getAuthenticatedUser() {
		return userService.getAuthenticatedUser();
	}
	
	@GetMapping(value="/{username}", produces = "application/json")
	public ResponseEntity<UserDTO> getAUser(@PathVariable String username) {
		return userService.getAUser(username);
	}

}
