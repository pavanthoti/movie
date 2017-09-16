package com.pavan.movie.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.movie.domain.Movie;

/**
 * Implementation of DAO for movies in database.
 * 
 */
@Service("movieDao")
@Transactional
public class MovieDaoImpl implements MovieDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public MovieDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly=true)
	public List<Movie> findAll() {
		return sessionFactory.getCurrentSession().createQuery("select m from Movie m order by m.id").list();
	}
	
	@Transactional(readOnly=true)
	public List<Movie> findAll(int page,int size) {
		return sessionFactory.getCurrentSession().createQuery("select m from Movie m order by m.id").setFirstResult(page-1).setMaxResults(size).list();
	}
	
	@Transactional(readOnly=true)
	public List<Movie> findAllWithRatings() {
		return sessionFactory.getCurrentSession().getNamedQuery("Movie.findAllWithRatings").list();
	}

	@Transactional(readOnly=true)
	public Movie findById(int id) {
		return (Movie)sessionFactory.getCurrentSession().getNamedQuery("Movie.findById").setParameter("id", id).uniqueResult();
	}

	@Transactional(readOnly=true)
	public int findCount() {
		Long count = (Long)sessionFactory.getCurrentSession().getNamedQuery("Movie.findCount").uniqueResult(); 
		return count.intValue();
	}

	public Movie save(Movie movie) {
		sessionFactory.getCurrentSession().saveOrUpdate(movie);
		return movie;
	}

	public void delete(Movie movie) {
		sessionFactory.getCurrentSession().delete(movie);
	}
	
}