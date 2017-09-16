package com.pavan.movie.service;

import com.pavan.movie.domain.Movie;
import com.pavan.movie.domain.Rating;
import com.pavan.movie.domain.User;

/**
 * Rating DAO Class
 * 
 */

public interface RatingDao {
	Rating findById(int id);
	Rating findByMovieAndUser(Movie movie,User user);
	Rating save(Rating rating);
}
