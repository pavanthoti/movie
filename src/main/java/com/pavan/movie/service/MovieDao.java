package com.pavan.movie.service;

import java.util.List;

import com.pavan.movie.domain.Movie;

/**
 * Movie DAO Class
 */
public interface MovieDao {
	List<Movie> findAll();
	List<Movie> findAll(int page,int size);
	List<Movie> findAllWithRatings();
	int findCount();
	Movie findById(int id);
	Movie save(Movie movie);
	void delete(Movie movie);
}
