package com.gustavo.gitpalm.dto;

import java.io.Serializable;

public class RepositoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String full_name;
	private String description;
	private String url;
	private Integer stargazers_count;
	private String language;
	private Integer forks_count;
	
	public RepositoryDTO() {
		
	}

	public RepositoryDTO(String name, String full_name, String description, String url, Integer stargazers_count,
			String language, Integer forks_count) {
		super();
		this.name = name;
		this.full_name = full_name;
		this.description = description;
		this.url = url;
		this.stargazers_count = stargazers_count;
		this.language = language;
		this.forks_count = forks_count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStargazers_count() {
		return stargazers_count;
	}

	public void setStargazers_count(Integer stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getForks_count() {
		return forks_count;
	}

	public void setForks_count(Integer forks_count) {
		this.forks_count = forks_count;
	}
	
}
