package com.maximiliano.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControllerFactory {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("PU");


	public static EntityManager getEntityManagerFactory() {
		return entityManagerFactory.createEntityManager();
	}

	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

};
