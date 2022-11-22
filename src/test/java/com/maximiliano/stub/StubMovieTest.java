package com.maximiliano.stub;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.controller.StubMovieController;
import com.maximiliano.models.Movie;

public class StubMovieTest {

	@Test
	public void createMovie() {
		Movie movie1 = StubMovieController.createMovie("The Godfather 2",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = StubMovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Godfather 2, description=The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void updateMovie() {
		Movie movie1 = StubMovieController.createMovie("The Godfather 4",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		StubMovieController.updateMovie(movie1.getId(), "The Father 40 - HD",
				"Clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = StubMovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Father 4 - HD, description=Clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void deleteMovie() {
		Movie movie1 = StubMovieController.createMovie("The Godfather 6",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		StubMovieController.deleteMovie(movie1.getId());

		Movie findMovie1 = StubMovieController.findMovie(movie1.getId());

		assertEquals(null, findMovie1);
	}

	@Test
	public void listMovies() {
		Movie movie1 = StubMovieController.createMovie("The Godfather 9",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie movie2 = StubMovieController.createMovie("I'm The Legend 9",
				"Aging patriarch of an organized crime.",
				"Action");

		Movie movie3 = StubMovieController.createMovie("The Shawshank Redemption",
				"Two imprisoned friends try to escape Alcatraz", "Drama");

		Movie findMovie1 = StubMovieController.findMovie(movie1.getId());
		Movie findMovie2 = StubMovieController.findMovie(movie2.getId());
		Movie findMovie3 = StubMovieController.findMovie(movie3.getId());

		assertEquals(findMovie1.toString(), movie1.toString());
		assertEquals(findMovie2.toString(), movie2.toString());
		assertEquals(findMovie3.toString(), movie3.toString());
	}

}
