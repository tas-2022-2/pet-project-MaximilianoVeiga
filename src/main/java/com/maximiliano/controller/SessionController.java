package com.maximiliano.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.maximiliano.model.Movie;
import com.maximiliano.model.Room;
import com.maximiliano.model.Session;

public class SessionController extends ControllerFactory {
	public SessionController() {
		super();
	}

	public static Session findSession(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Session session = entityManager.find(Session.class, id);

		entityManager.getTransaction().commit();

		session.setAvailableSeats(session.getRoom().getCapacity());

		return session;
	}

	public static Session createSession(Timestamp timestamp, String room_id, String movie_id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Session session = new Session();

		session.setTimestamp(timestamp);

		Room room = entityManager.find(Room.class, room_id);
		Movie movie = entityManager.find(Movie.class, movie_id);

		if (room == null) {
			throw new IllegalArgumentException("Room not found");
		} else if (movie == null) {
			throw new IllegalArgumentException("Movie not found");
		}

		Query query = entityManager.createNativeQuery("SELECT * FROM session S WHERE s.timestamp = ? AND s.room_id = ?");  
		query.setParameter(1, timestamp);
		query.setParameter(2, room_id);

		List<Session> vetSessions = query.getResultList();

		if (vetSessions.size() > 0) {
			throw new IllegalArgumentException("Session already exists at the specified time");
		}

		session.setRoom(room);
		session.setMovie(movie);
		
		session.setAvailableSeats(room.getCapacity());

		entityManager.persist(session);
		entityManager.getTransaction().commit();

		return session;
	}

	public static List<Session> listSessions() {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		List<Session> vetSession = entityManager.createQuery("SELECT s FROM session s", Session.class).getResultList();

		entityManager.getTransaction().commit();

		return vetSession;
	}

	public static void updateSession(String id, Timestamp timestamp, String room_id, String movie_id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Session session = entityManager.find(Session.class, id);

		session.setTimestamp(timestamp);
		session.setRoom(entityManager.find(Room.class, room_id));
		session.setMovie(entityManager.find(Movie.class, movie_id));

		entityManager.merge(session);
		entityManager.getTransaction().commit();
	}

	public static void deleteSession(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Session session = entityManager.find(Session.class, id);

		entityManager.remove(session);
		entityManager.getTransaction().commit();
	}

};
