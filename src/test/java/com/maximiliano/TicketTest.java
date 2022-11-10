package com.maximiliano;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;

import com.maximiliano.model.Movie;
import com.maximiliano.model.Room;
import com.maximiliano.model.Session;
import com.maximiliano.model.Ticket;
import com.maximiliano.util.Time;

public class TicketTest {
    
    @Test
	public void createTicket() {
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

        Ticket ticket1 = new Ticket();
        
        ticket1.setClientName("Jorge");
        ticket1.setSession(session1);
        ticket1.setSeat("1A");
        
        String expected1 = "Ticket [id=" + ticket1.getId() + ", clientName=Jorge, seat=1A, session=" + session1.toString() + "]";

        assertEquals(expected1, ticket1.toString());
    }

    @Test
    public void updateTicket() {
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

        Ticket ticket1 = new Ticket();
        
        ticket1.setClientName("Jorge");
        ticket1.setSession(session1);
        ticket1.setSeat("1A");
        
        ticket1.setClientName("João");
        ticket1.setSession(session1);
        ticket1.setSeat("1B");
        
        String expected1 = "Ticket [id=" + ticket1.getId() + ", clientName=João, seat=1B, session=" + session1.toString() + "]";

        assertEquals(expected1, ticket1.toString());
    }

}
