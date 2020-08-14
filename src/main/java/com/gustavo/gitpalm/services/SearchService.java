package com.gustavo.gitpalm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gustavo.gitpalm.api.ApiBinding;
import com.gustavo.gitpalm.dto.SearchRepositoryDTO;

@Service
public class SearchService {
	
	@Autowired
	private ApiBinding apiBinding;
	
	public ResponseEntity<SearchRepositoryDTO> searchRepositories(String query, String sort, String order, Integer per_page, Integer page){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.github.com")
				.path("/search/repositories")
				.queryParam("q", query)
				.queryParam("sort", sort)
				.queryParam("order", order)
				.queryParam("per_page", per_page)
				.queryParam("page", page)
				.build();
		
		return apiBinding.getRestTemplate().exchange(uri.toString(), HttpMethod.GET, null, SearchRepositoryDTO.class);
	}
	
}
