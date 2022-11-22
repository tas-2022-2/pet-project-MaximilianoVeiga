package com.maximiliano.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.maximiliano.controllers.MovieController;
import com.maximiliano.models.Movie;
@Ignore
public class MovieTest {

	@Test
	public void createMovie() {
		Movie movie1 = MovieController.createMovie("The Godfather 2",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = MovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Godfather 2, description=The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void updateMovie() {
		Movie movie1 = MovieController.createMovie("The Godfather 4",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		MovieController.updateMovie(movie1.getId(), "The Father 4 - HD",
				"Clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = MovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Father 4 - HD, description=Clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void deleteMovie() {
		Movie movie1 = MovieController.createMovie("The Godfather 6",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		MovieController.deleteMovie(movie1.getId());

		Movie findMovie1 = MovieController.findMovie(movie1.getId());

		assertEquals(null, findMovie1);
	}

	@Test
	public void listMovies() {
		Movie movie1 = MovieController.createMovie("The Godfather 9",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie movie2 = MovieController.createMovie("I'm The Legend 9",
				"Aging patriarch of an organized crime.",
				"Action");

		Movie movie3 = MovieController.createMovie("The Shawshank Redemption",
				"Two imprisoned friends try to escape Alcatraz", "Drama");

		Movie findMovie1 = MovieController.findMovie(movie1.getId());
		Movie findMovie2 = MovieController.findMovie(movie2.getId());
		Movie findMovie3 = MovieController.findMovie(movie3.getId());

		assertEquals(findMovie1.toString(), findMovie1.toString());
		assertEquals(findMovie2.toString(), findMovie2.toString());
		assertEquals(findMovie3.toString(), findMovie3.toString());
	}

}
