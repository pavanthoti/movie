package com.pavan.movie.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.UserIdSource;
import org.springframework.stereotype.Component;

import com.pavan.movie.service.UserDao;

@Component
public class CurrentUserIdSource implements UserIdSource{
	@Autowired
	private UserDao userDao;
	
	private String userId = "anonymous"; 
	
	public String getUserId() {
		return userDao.getAuthenticatedUser().getUsername();
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
