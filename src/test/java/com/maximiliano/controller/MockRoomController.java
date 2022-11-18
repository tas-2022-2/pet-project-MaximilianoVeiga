package com.maximiliano.controller;

import java.util.ArrayList;
import java.util.List;

import com.maximiliano.models.Room;

public class MockRoomController {

    static List<Room> rooms = new ArrayList<Room>();

    public static Room createRoom(String name, int capacity) {
		Room room = new Room();

        for (Room r : rooms) {
            if (r.getName().equals(name)) {
                return null;
            }
        }

        if (name == null || name.equals("") || capacity <= 0) {
            return null;
        }

        room.setName(name);
        room.setCapacity(capacity);

		rooms.add(room);

		return room;
	}

    public static List<Room> listRooms() {
        return rooms;
    }

    public static void deleteRoom(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                rooms.remove(room);
                break;
            }
        }
    }

    public static Room findRoom(String id) {
        if (id == null || id.equals("")) {
            return null;
        }

        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public static void updateRoom(String id, String name, int capacity) {
        if (name == null || name.equals("") || capacity <= 0) {
            return;
        }

        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                room.setName(name);
                room.setCapacity(capacity);
                break;
            }
        }
    }

}
