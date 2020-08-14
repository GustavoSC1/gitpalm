package com.gustavo.gitpalm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchRepositoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long total_count;
	private boolean incomplete_results;
	private List<RepositoryDTO> items = new ArrayList<>();
	
	public SearchRepositoryDTO() {
		
	}

	public SearchRepositoryDTO(Long total_count, boolean incomplete_results) {
		super();
		this.total_count = total_count;
		this.incomplete_results = incomplete_results;
	}

	public Long getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	public boolean isIncomplete_results() {
		return incomplete_results;
	}

	public void setIncomplete_results(boolean incomplete_results) {
		this.incomplete_results = incomplete_results;
	}

	public List<RepositoryDTO> getItems() {
		return items;
	}

	public void setItems(List<RepositoryDTO> items) {
		this.items = items;
	}
	
}
