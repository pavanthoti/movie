package com.pavan.movie.facebook;

import org.springframework.social.UserIdSource;

public class StaticUserIdSource implements UserIdSource{
	private String userId = "anonymous"; 

	public String getUserId() {
		return "anonymous";
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
