package com.maximiliano.view;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.maximiliano.controller.MovieController;
import com.maximiliano.controller.RoomController;
import com.maximiliano.controller.SessionController;
import com.maximiliano.controller.TicketController;
import com.maximiliano.model.Movie;
import com.maximiliano.model.Room;
import com.maximiliano.model.Session;
import com.maximiliano.model.Ticket;

public class Main {

	public static void main(String[] args) {

		System.out.println("Program start...");

		// Create a movie using movie controller
		Movie movie1 = MovieController.createMovie("The Godfather",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie movie2 = MovieController.createMovie("I'm The Legend",
				"Aging patriarch of an organized crime.",
				"Action");

		Movie movie3 = MovieController.createMovie("The Shawshank Redemption",
				"Two imprisoned friends try to escape Alcatraz", "Drama");

		// Get a movie using movie controller
		Movie findMovie1 = MovieController.findMovie(movie2.getId());
		System.out.println("FIND 1: " + findMovie1.toString());

		Movie findMovie2 = MovieController.findMovie(movie1.getId());
		System.out.println("FIND 2: " + findMovie2.toString());

		// Update a movie using movie controller
		MovieController.updateMovie(movie1.getId(), "The Father",
				"Clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie3 = MovieController.findMovie(movie1.getId());
		System.out.println("FIND 1 - EDIT: " + findMovie3.toString());

		// Delete a movie using movie controller
		MovieController.deleteMovie(movie3.getId());

		// List all movies using movie controller
		List<Movie> vetMovies = MovieController.listMovies();
		for (int i = 0; i < vetMovies.size(); i++) {
			Movie x = vetMovies.get(i);
			System.out.println("LIST: " + x.toString());
		}

		System.out.println("----------------------------------------------------");

		// Create a room using room controller
		Room room1 = RoomController.createRoom("Room 1", 5);
		Room room2 = RoomController.createRoom("Room 2", 75);
		Room room3 = RoomController.createRoom("Room 3", 50);

		// Get a room using room controller
		Room findRoom1 = RoomController.findRoom(room1.getId());
		System.out.println("FIND 1: " + findRoom1.toString());

		Room findRoom2 = RoomController.findRoom(room2.getId());
		System.out.println("FIND 2: " + findRoom2.toString());

		// Update a room using room controller
		RoomController.updateRoom(room1.getId(), "Room 1A", 5);

		Room findRoom3 = RoomController.findRoom(room1.getId());
		System.out.println("FIND 1 - EDIT: " + findRoom3.toString());

		// Delete a room using room controller
		RoomController.deleteRoom(room3.getId());

		// List all rooms using room controller
		List<Room> vetRooms = RoomController.listRooms();
		for (int i = 0; i < vetRooms.size(); i++) {
			Room x = vetRooms.get(i);
			System.out.println("LIST: " + x.toString());
		}

		System.out.println("----------------------------------------------------");

		// Create a session using session controller
		Timestamp timestamp1 = newTimestamp(29, 10, 2022, 18, 00, 00);
		Session session1 = SessionController.createSession(timestamp1, room2.getId(), movie2.getId());

		Timestamp timestamp2 = newTimestamp(29, 9, 2022, 22, 00, 00);
		Session session2 = SessionController.createSession(timestamp2, room1.getId(), movie2.getId());

		Timestamp timestamp3 = newTimestamp(29, 9, 2022, 10, 00, 00);
		Session session3 = SessionController.createSession(timestamp3, room1.getId(), movie1.getId());

		// Get a session using session controller
		Session findSession1 = SessionController.findSession(session1.getId());
		System.out.println("FIND 1: " + findSession1.toString());

		Session findSession2 = SessionController.findSession(session2.getId());
		System.out.println("FIND 2: " + findSession2.toString());

		// Update a session using session controller
		SessionController.updateSession(session1.getId(), timestamp1, room1.getId(), movie2.getId());

		Session findSession3 = SessionController.findSession(session1.getId());
		System.out.println("FIND 1 - EDIT: " + findSession3.toString());

		System.out.println((findSession3.getTimestamp().after(new java.util.Date())));

		// Delete a session using session controller
		SessionController.deleteSession(session3.getId());

		// List all sessions using session controller
		List<Session> vetSessions = SessionController.listSessions();
		for (int i = 0; i < vetSessions.size(); i++) {
			Session x = vetSessions.get(i);
			System.out.println("LIST: " + x.toString());
		}

		System.out.println("----------------------------------------------------");

		// Create a ticket using ticket controller
		Ticket ticket1 = TicketController.createTicket("Jubileu", "1", session1.getId());
		Ticket ticket2 = TicketController.createTicket("Jackan", "2", session1.getId());
		Ticket ticket3 = TicketController.createTicket("Joelson", "5", session1.getId());
		TicketController.createTicket("Jupiter", "3", session1.getId());
		TicketController.createTicket("Jacinto", "4", session1.getId());

		// Get a ticket using ticket controller
		Ticket findTicket1 = TicketController.findTicket(ticket1.getId());
		System.out.println("FIND 1: " + findTicket1.toString());

		Ticket findTicket2 = TicketController.findTicket(ticket2.getId());
		System.out.println("FIND 2: " + findTicket2.toString());

		// Update a ticket using ticket controller
		TicketController.updateTicket(ticket1.getId(), "Max", "10", session2.getId());

		Ticket findTicket3 = TicketController.findTicket(ticket1.getId());
		System.out.println("FIND 1 - EDIT: " + findTicket3.toString());

		// Delete a ticket using ticket controller
		TicketController.deleteTicket(ticket3.getId());

		TicketController.createTicket("Max", "5", session1.getId());

		// List all tickets using ticket controller
		List<Ticket> vetTickets = TicketController.listTickets();
		for (int i = 0; i < vetTickets.size(); i++) {
			Ticket x = vetTickets.get(i);
			System.out.println("LIST: " + x.toString());
		}

		System.out.println("----------------------------------------------------");
	}

	public static Timestamp newTimestamp(int day, int month, int year, int hour, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute, second);
		return new Timestamp(calendar.getTime().getTime());
	}

};
