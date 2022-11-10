package com.maximiliano.mock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.controller.MockMovieController;
import com.maximiliano.models.Movie;

public class MockMovieTest {

	@Test
	public void createMovie() {
		Movie movie1 = MockMovieController.createMovie("The Godfather 2",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = MockMovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Godfather 2, description=The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void updateMovie() {
		Movie movie1 = MockMovieController.createMovie("The Godfather 4",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		MockMovieController.updateMovie(movie1.getId(), "The Father 4 - HD",
				"Clandestine empire to his reluctant son.",
				"Crime");

		Movie findMovie1 = MockMovieController.findMovie(movie1.getId());

		String expected = "Movie [id=" + movie1.getId()
				+ ", title=The Father 4 - HD, description=Clandestine empire to his reluctant son., genre=Crime]";

		assertEquals(expected, findMovie1.toString());
	}

	@Test
	public void deleteMovie() {
		Movie movie1 = MockMovieController.createMovie("The Godfather 6",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		MockMovieController.deleteMovie(movie1.getId());

		Movie findMovie1 = MockMovieController.findMovie(movie1.getId());

		assertEquals(null, findMovie1);
	}

	@Test
	public void listMovies() {
		Movie movie1 = MockMovieController.createMovie("The Godfather 9",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"Crime");

		Movie movie2 = MockMovieController.createMovie("I'm The Legend 9",
				"Aging patriarch of an organized crime.",
				"Action");

		Movie movie3 = MockMovieController.createMovie("The Shawshank Redemption",
				"Two imprisoned friends try to escape Alcatraz", "Drama");

		MockMovieController.listMovies();

		String expectedMovie1 = "Movie [id=" + movie1.getId()
				+ ", title=The Godfather 9, description=The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son., genre=Crime]";
		String expectedMovie2 = "Movie [id=" + movie2.getId()
				+ ", title=I'm The Legend 9, description=Aging patriarch of an organized crime., genre=Action]";
		String expectedMovie3 = "Movie [id=" + movie3.getId()
				+ ", title=The Shawshank Redemption, description=Two imprisoned friends try to escape Alcatraz, genre=Drama]";

		assertEquals(expectedMovie1, movie1.toString());
		assertEquals(expectedMovie2, movie2.toString());
		assertEquals(expectedMovie3, movie3.toString());
	}

}
