package com.maximiliano.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.maximiliano.model.Session;
import com.maximiliano.model.Ticket;

public class TicketController extends ControllerFactory {
	public TicketController() {
		super();
	}

	public static Ticket findTicket(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Ticket ticket = entityManager.find(Ticket.class, id);

		entityManager.getTransaction().commit();

		return ticket;
	}

	public static Ticket createTicket(String clientName, String seat, String session_id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Ticket ticket = new Ticket();

		ticket.setClientName(clientName);
		ticket.setSeat(seat);

		Session session = entityManager.find(Session.class, session_id);

		if (session == null) {
			throw new IllegalArgumentException("Session not found");
		}

		if (session.getTimestamp().before(new java.util.Date())) {
			throw new IllegalArgumentException(
					"Session is not available because it has already happened");
		}

		List<Ticket> vetTicket = entityManager.createQuery("SELECT t FROM ticket t WHERE t.seat = :seatValue", Ticket.class).setParameter("seatValue", seat).getResultList();

		if (vetTicket.size() > 0) {
			throw new IllegalArgumentException("Seat already sold");
		}
		
		Query query = entityManager.createNativeQuery("SELECT * FROM ticket t WHERE t.session_id = ?");  
		query.setParameter(1, session_id);
		List<Ticket> vetTickets = query.getResultList();

		if (vetTickets.size() >= session.getRoom().getCapacity()) {
			throw new IllegalArgumentException("Session is sold out");
		}

		ticket.setSession(session);

		entityManager.persist(ticket);
		entityManager.getTransaction().commit();

		return ticket;
	}

	public static List<Ticket> listTickets() {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		List<Ticket> vetTicket = entityManager.createQuery("SELECT t FROM ticket t", Ticket.class).getResultList();

		entityManager.getTransaction().commit();

		return vetTicket;
	}

	public static void updateTicket(String id, String clientName, String seat, String session_id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Ticket ticket = entityManager.find(Ticket.class, id);

		ticket.setClientName(clientName);
		ticket.setSeat(seat);
		ticket.setSession(entityManager.find(Session.class, session_id));

		entityManager.merge(ticket);
	}

	public static void deleteTicket(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Ticket ticket = entityManager.find(Ticket.class, id);

		entityManager.remove(ticket);
		entityManager.getTransaction().commit();
	}

};