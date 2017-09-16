package com.pavan.movie.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.movie.domain.Movie;
import com.pavan.movie.domain.Rating;
import com.pavan.movie.domain.User;

/**
 * Implementation of DAO for ratings.
 */
@Service("ratingDao")
@Transactional
public class RatingDaoImpl implements RatingDao{
	
private SessionFactory sessionFactory;
	
	@Autowired
	public RatingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Rating findById(int id) {
		return (Rating)sessionFactory.getCurrentSession().getNamedQuery("Rating.findById").setParameter("id", id).uniqueResult();
	}

	public Rating findByMovieAndUser(Movie movie, User user) {
		return (Rating) sessionFactory.getCurrentSession().getNamedQuery("Rating.findByUserAndMovie").setParameter("userId", user.getId()).setParameter("movieId", movie.getId()).uniqueResult();
	}

	public Rating save(Rating rating) {
		sessionFactory.getCurrentSession().saveOrUpdate(rating);
		return rating;
	}

}
