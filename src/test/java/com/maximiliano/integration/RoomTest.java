package com.maximiliano.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.controllers.RoomController;
import com.maximiliano.models.Room;

public class RoomTest {

	@Test
	public void createRoom() {
		Room room1 = RoomController.createRoom("Room 1", 10);

		Room findRoom1 = RoomController.findRoom(room1.getId());

		String expected = "Room [id=" + room1.getId() + ", name=Room 1, capacity=10]";

		assertEquals(expected, findRoom1.toString());
	}

	@Test
	public void updateRoom() {
		Room room1 = RoomController.createRoom("Room 1H", 10);

		RoomController.updateRoom(room1.getId(), "Room 1J", 20);

		Room findRoom1 = RoomController.findRoom(room1.getId());

		String expected = "Room [id=" + room1.getId() + ", name=Room 1J, capacity=20]";

		assertEquals(expected, findRoom1.toString());
	}

	@Test
	public void deleteRoom() {
		Room room1 = RoomController.createRoom("Room 1C", 10);

		RoomController.deleteRoom(room1.getId());

		Room findRoom1 = RoomController.findRoom(room1.getId());

		assertEquals(null, findRoom1);
	}

}
