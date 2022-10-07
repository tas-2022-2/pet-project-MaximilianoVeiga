package com.maximiliano;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.maximiliano.controller.MovieController;
import com.maximiliano.controller.RoomController;
import com.maximiliano.controller.SessionController;
import com.maximiliano.model.Movie;
import com.maximiliano.model.Room;
import com.maximiliano.model.Session;

public class SessionTest {

	@Test
	public void createSession() {
		Movie movie1 = MovieController.createMovie("The Godfather Ultra",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie movie2 = MovieController.createMovie("The Godfather Ultra - 3D",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Room room1 = RoomController.createRoom("Room 1A", 10);

		Timestamp timestamp1 = newTimestamp(29, 8, 2022, 22, 00, 00);
		Session session1 = SessionController.createSession(timestamp1, room1.getId(), movie1.getId());

		Room room2 = RoomController.createRoom("Room 2B", 10);

		Timestamp timestamp2 = newTimestamp(03, 9, 2022, 22, 00, 00);
		Session session2 = SessionController.createSession(timestamp2, room2.getId(), movie2.getId());

		Session findSession1 = SessionController.findSession(session1.getId());
		String expected1 = "Session [id=" + session1.getId() + ", timestamp=2022-09-29 22:00:00.0, tickets=[], room="
				+ room1.toString()
				+ ", movie=" + movie1.toString() + "]";

		Session findSession2 = SessionController.findSession(session2.getId());
		String expected2 = "Session [id=" + session2.getId() + ", timestamp=2022-10-03 22:00:00.0, tickets=[], room="
				+ room2.toString()
				+ ", movie=" + movie2.toString() + "]";

		assertEquals(expected1, findSession1.toString());
		assertEquals(expected2, findSession2.toString());
	}

	@Test
	public void updateSession() {
		Movie movie1 = MovieController.createMovie("The Godfather",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Room room1 = RoomController.createRoom("Room 4U", 10);

		Timestamp timestamp1 = newTimestamp(29, 9, 2022, 22, 00, 00);
		Session session1 = SessionController.createSession(timestamp1, room1.getId(), movie1.getId());

		Movie movie2 = MovieController.createMovie("The Godfather 2 - 4D",
				"The early life and career of Vito Corleone in 1920s New York is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
				"Crime");

		Room room2 = RoomController.createRoom("Room 4J", 10);

		Timestamp timestamp2 = newTimestamp(03, 9, 2022, 22, 00, 00);

		SessionController.updateSession(session1.getId(), timestamp2, room2.getId(), movie2.getId());

		Session findSession1 = SessionController.findSession(session1.getId());

		String expected = "Session [id=" + session1.getId() + ", timestamp=2022-10-03 22:00:00.0, tickets=[], room="
				+ room2.toString()
				+ ", movie=" + movie2.toString() + "]";

		assertEquals(expected, findSession1.toString());
	}

	public static Timestamp newTimestamp(int day, int month, int year, int hour, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute, second);
		return new Timestamp(calendar.getTime().getTime());
	}
}
