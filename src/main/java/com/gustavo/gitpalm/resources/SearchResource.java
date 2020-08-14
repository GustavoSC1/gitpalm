package com.gustavo.gitpalm.resources;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.gitpalm.dto.SearchRepositoryDTO;
import com.gustavo.gitpalm.dto.SearchUserDTO;
import com.gustavo.gitpalm.services.SearchService;

@RestController
@RequestMapping(value="/search")
public class SearchResource {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping(value="/repositories")
	public ResponseEntity<SearchRepositoryDTO> searchRepositories(@RequestParam(value="q") String query,
			@RequestParam(value="sort", defaultValue="") String sort,
			@RequestParam(value="order", defaultValue="desc") String order,
			@RequestParam(value="per_page", defaultValue="30") Integer per_page,
			@RequestParam(value="page", defaultValue="0") Integer page){
		
		return searchService.searchRepositories(query, sort, order, per_page, page);		
	}
	
	@GetMapping(value="/users")
	public ResponseEntity<SearchUserDTO> searchUsers(@RequestParam(value="q") String query,
			@RequestParam(value="sort", defaultValue="") String sort,
			@RequestParam(value="order", defaultValue="desc") String order,
			@RequestParam(value="per_page", defaultValue="30") Integer per_page,
			@RequestParam(value="page", defaultValue="0") Integer page){
		
		return searchService.searchUsers(query, sort, order, per_page, page);		
	}

}
