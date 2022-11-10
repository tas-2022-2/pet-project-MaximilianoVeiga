package com.maximiliano;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.models.Room;

public class RoomTest {

    @Test
	public void createRoom() {
        Room room1 = new Room();

        room1.setName("Room 1");
        room1.setCapacity(10);

        String expected = "Room [id=" + room1.getId() + ", name=Room 1, capacity=10]";

        assertEquals(expected, room1.toString());
    }

    @Test
    public void updateRoom() {
        Room room1 = new Room();
        
        room1.setName("Room 1");
        room1.setCapacity(10);

        room1.setName("Room 1J");
        room1.setCapacity(20);

        String expected = "Room [id=" + room1.getId() + ", name=Room 1J, capacity=20]";

        assertEquals(expected, room1.toString());
    }
    
}
