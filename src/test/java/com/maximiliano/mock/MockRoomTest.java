package com.maximiliano.mock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.controller.MockRoomController;
import com.maximiliano.models.Room;

public class MockRoomTest {

    @Test
	public void createRoom() {
        Room room1 = MockRoomController.createRoom("Room 1", 10);

        Room findRoom1 = MockRoomController.findRoom(room1.getId());

        String expected = "Room [id=" + room1.getId() + ", name=Room 1, capacity=10]";

        assertEquals(expected, findRoom1.toString());
    }

    @Test
	public void updateRoom() {
        Room room1 = MockRoomController.createRoom("Room 1H", 10);

        MockRoomController.updateRoom(room1.getId(), "Room 1J", 20);

        Room findRoom1 = MockRoomController.findRoom(room1.getId());

        String expected = "Room [id=" + room1.getId() + ", name=Room 1J, capacity=20]";

        assertEquals(expected, findRoom1.toString());
    }

    @Test
    public void deleteRoom() {
        Room room1 = MockRoomController.createRoom("Room 1C", 10);

        MockRoomController.deleteRoom(room1.getId());

        Room findRoom1 = MockRoomController.findRoom(room1.getId());

        assertEquals(null, findRoom1);
    }

    @Test
    public void listRooms() {
        Room room1 = MockRoomController.createRoom("Room 1C", 10);
        Room room2 = MockRoomController.createRoom("Room 2C", 20);
        Room room3 = MockRoomController.createRoom("Room 3C", 30);

        Room findRoom1 = MockRoomController.findRoom(room1.getId());
        Room findRoom2 = MockRoomController.findRoom(room2.getId());
        Room findRoom3 = MockRoomController.findRoom(room3.getId());
         
        assertEquals(room1.toString(), findRoom1.toString());
        assertEquals(room2.toString(), findRoom2.toString());
        assertEquals(room3.toString(), findRoom3.toString());
    }

    
}
