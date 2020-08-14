package com.gustavo.gitpalm.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private Long id;
	private String node_id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String followers_url;
	private String subscriptions_url;
	private String organizations_url;
	private String repos_url;
	private String received_events_url;
	private String type;
	private Double score;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String login, Long id, String node_id, String avatar_url, String gravatar_id, String url,
			String html_url, String followers_url, String subscriptions_url, String organizations_url, String repos_url,
			String received_events_url, String type, Double score) {
		super();
		this.login = login;
		this.id = id;
		this.node_id = node_id;
		this.avatar_url = avatar_url;
		this.gravatar_id = gravatar_id;
		this.url = url;
		this.html_url = html_url;
		this.followers_url = followers_url;
		this.subscriptions_url = subscriptions_url;
		this.organizations_url = organizations_url;
		this.repos_url = repos_url;
		this.received_events_url = received_events_url;
		this.type = type;
		this.score = score;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getGravatar_id() {
		return gravatar_id;
	}

	public void setGravatar_id(String gravatar_id) {
		this.gravatar_id = gravatar_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getFollowers_url() {
		return followers_url;
	}

	public void setFollowers_url(String followers_url) {
		this.followers_url = followers_url;
	}

	public String getSubscriptions_url() {
		return subscriptions_url;
	}

	public void setSubscriptions_url(String subscriptions_url) {
		this.subscriptions_url = subscriptions_url;
	}

	public String getOrganizations_url() {
		return organizations_url;
	}

	public void setOrganizations_url(String organizations_url) {
		this.organizations_url = organizations_url;
	}

	public String getRepos_url() {
		return repos_url;
	}

	public void setRepos_url(String repos_url) {
		this.repos_url = repos_url;
	}

	public String getReceived_events_url() {
		return received_events_url;
	}

	public void setReceived_events_url(String received_events_url) {
		this.received_events_url = received_events_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
}
