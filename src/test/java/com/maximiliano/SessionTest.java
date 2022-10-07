package com.maximiliano;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;

import com.maximiliano.model.Movie;
import com.maximiliano.model.Room;
import com.maximiliano.model.Session;
import com.maximiliano.util.Time;

public class SessionTest {
    
    @Test
	public void createSession() {
        Movie movie1 = new Movie();

        movie1.setTitle("The Godfather 2");
        movie1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie1.setGenre("Crime");

        Room room1 = new Room();

        room1.setName("Room 1");
        room1.setCapacity(10);

        Timestamp timestamp2 = Time.create(29, 8, 2022, 22, 00, 00);

        Session session1 = new Session();
        session1.setMovie(movie1);
        session1.setRoom(room1);
        session1.setAvailableSeats(10);
        session1.setTimestamp(timestamp2);

        String expected1 = "Session [id=" + session1.getId() + ", timestamp=" + Time.toString(timestamp2) + ", tickets=[], room="
                + room1.toString()
                + ", movie=" + movie1.toString() + "]";

        assertEquals(expected1, session1.toString());
    }

    @Test
    public void updateSession() {
        Movie movie1 = new Movie();

        movie1.setTitle("The Godfather 2");
        movie1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie1.setGenre("Crime");

        Room room1 = new Room();

        room1.setName("Room 1");
        room1.setCapacity(10);

        Timestamp timestamp1 = Time.create(29, 9, 2022, 22, 00, 00);

        Session session1 = new Session();
        session1.setMovie(movie1);
        session1.setRoom(room1);
        session1.setAvailableSeats(10);
        session1.setTimestamp(timestamp1);

        Movie movie2 = new Movie();

        movie2.setTitle("The Godfather 2");
        movie2.setDescription("The early life and career of Vito Corleone in 1920s New York is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.");
        movie2.setGenre("Crime");

        Room room2 = new Room();

        room2.setName("Room 2");
        room2.setCapacity(10);

        Timestamp timestamp2 = Time.create(03, 9, 2022, 22, 00, 00);

        session1.setMovie(movie2);
        session1.setRoom(room2);
        session1.setTimestamp(timestamp2);

        String expected1 = "Session [id=" + session1.getId() + ", timestamp=" + Time.toString(timestamp2) + ", tickets=[], room="
                + room2.toString()
                + ", movie=" + movie2.toString() + "]";

        assertEquals(expected1, session1.toString());
    }

        
}
