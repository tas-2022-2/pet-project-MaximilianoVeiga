package com.maximiliano.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.maximiliano.model.Movie;

public class MovieController extends ControllerFactory {
	public MovieController() {
		super();
	}

	public static Movie findMovie(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Movie movie = entityManager.find(Movie.class, id);

		entityManager.getTransaction().commit();

		return movie;
	}

	public static Movie createMovie(String title, String description, String genre) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Movie movie = new Movie();

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setGenre(genre);

		entityManager.persist(movie);
		entityManager.getTransaction().commit();

		return movie;
	}

	public static List<Movie> listMovies() {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		List<Movie> vetMovie = entityManager.createQuery("SELECT m FROM movie m", Movie.class).getResultList();

		entityManager.getTransaction().commit();

		return vetMovie;
	}

	public static void updateMovie(String id, String title, String description, String genre) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Movie movie = entityManager.find(Movie.class, id);

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setGenre(genre);

		entityManager.merge(movie);
		entityManager.getTransaction().commit();
	}

	public static void deleteMovie(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Movie movie = entityManager.find(Movie.class, id);

		entityManager.remove(movie);
		entityManager.getTransaction().commit();
	}

};
