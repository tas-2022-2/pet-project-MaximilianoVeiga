package com.maximiliano.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.maximiliano.model.Room;

public class RoomController extends ControllerFactory {
	public RoomController() {
		super();
	}

	public static Room findRoom(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Room room = entityManager.find(Room.class, id);

		entityManager.getTransaction().commit();

		return room;
	}

	public static Room createRoom(String name, int capacity) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Room room = new Room();

		room.setName(name);
		room.setCapacity(capacity);

		entityManager.persist(room);
		entityManager.getTransaction().commit();

		return room;
	}

	public static List<Room> listRooms() {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		List<Room> vetRoom = entityManager.createQuery("SELECT r FROM room r", Room.class).getResultList();

		entityManager.getTransaction().commit();

		return vetRoom;
	}

	public static void updateRoom(String id, String name, int capacity) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Room room = entityManager.find(Room.class, id);

		room.setName(name);
		room.setCapacity(capacity);

		entityManager.merge(room);
		entityManager.getTransaction().commit();
	}

	public static void deleteRoom(String id) {
		EntityManager entityManager = getEntityManagerFactory();
		entityManager.getTransaction().begin();

		Room room = entityManager.find(Room.class, id);

		entityManager.remove(room);
		entityManager.getTransaction().commit();
	}

};
