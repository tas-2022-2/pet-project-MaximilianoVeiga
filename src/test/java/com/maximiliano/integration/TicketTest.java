package com.maximiliano.integration;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;

import com.maximiliano.controllers.MovieController;
import com.maximiliano.controllers.RoomController;
import com.maximiliano.controllers.SessionController;
import com.maximiliano.controllers.TicketController;
import com.maximiliano.models.Movie;
import com.maximiliano.models.Room;
import com.maximiliano.models.Session;
import com.maximiliano.models.Ticket;

@Ignore
public class TicketTest {

	@Test
	public void createTicket() {
		Movie movie1 = MovieController.createMovie("The Last of Us",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Room room1 = RoomController.createRoom("Room 1P", 10);
		Timestamp timestamp1 = newTimestamp(29, 9, 2022, 22, 00, 00);
		Session session1 = SessionController.createSession(timestamp1, room1.getId(), movie1.getId());
		Ticket ticket1 = TicketController.createTicket("Max", "10", session1.getId());

		System.out.println(ticket1.toString());

		assertEquals(
				"Ticket [id=" + ticket1.getId() + ", clientName=Max, seat=10, session="
						+ session1.toString().replace("null", "[]") + "]",
				ticket1.toString());

	}

	@Test
	public void deleteTicket() {
		Movie movie1 = MovieController.createMovie("The Venom 2",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Room room1 = RoomController.createRoom("Room 1B", 10);
		Timestamp timestamp1 = newTimestamp(29, 9, 2022, 22, 00, 00);
		Session session1 = SessionController.createSession(timestamp1, room1.getId(), movie1.getId());
		Ticket ticket1 = TicketController.createTicket("Max", "10", session1.getId());

		TicketController.deleteTicket(ticket1.getId());

		assertEquals(null, TicketController.findTicket(ticket1.getId()));
	}

	public static Timestamp newTimestamp(int day, int month, int year, int hour, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute, second);
		return new Timestamp(calendar.getTime().getTime());
	}
}
