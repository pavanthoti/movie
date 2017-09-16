package com.pavan.movie.service;

import java.util.List;

import com.pavan.movie.domain.User;

/**
 * DAO for application users.
 */
public interface UserDao {
	User findByUsername(String username);
	List<User> findByRole(String role);
	User getAuthenticatedUser();
	List<User> findAllNonVerifiedUsers();
	User findUserByVerificationCode(String verificationCode);
	User save(User user);
	void deleteNonVerifiedUsers();
	void delete(User user);
}
