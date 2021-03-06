package com.gustavo.gitpalm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.gitpalm.dto.RepositoryDTO;
import com.gustavo.gitpalm.services.RepositoryService;

@RestController
@RequestMapping(value="/respositories")
public class RepositoryResource {
	
	@Autowired
	private RepositoryService repositoryService;
	
	//produces = It means that the method will produce json as a result and will be sent in response.
	//hey only serve to restrict the mapping to your request managers
	// https://dzone.com/articles/using-the-spring-requestmapping-annotation
	@GetMapping(value="/user/repos", produces = "application/json")
	public ResponseEntity<List<RepositoryDTO>> listUserRepository(@RequestParam(value="visibility", defaultValue="all") String visibility,
			@RequestParam(value="affiliation", defaultValue="owner,collaborator,organization_member") String affiliation,
			@RequestParam(value="sort", defaultValue="full_name") String sort,
			@RequestParam(value = "direction", defaultValue="") String direction){		
		return repositoryService.listUserRepository(visibility, affiliation, sort, direction);
	}
	
	@GetMapping(value="/{username}/repos", produces = "application/json")
	public ResponseEntity<List<RepositoryDTO>> listSpecifiedUserRepository(@PathVariable String username, 
			@RequestParam(value="type", defaultValue="owner") String type,
			@RequestParam(value="sort", defaultValue="full_name") String sort, 
			@RequestParam(value="direction", defaultValue="") String direction){
		
		return repositoryService.listSpecifiedUserRepository(username, type, sort, direction);
	}
	
	@GetMapping(value="{owner}/{repo}", produces = "application/json")
	public ResponseEntity<RepositoryDTO> getRepository(@PathVariable String owner, @PathVariable String repo){
		return repositoryService.getRepository(owner, repo);
	}
	
}
