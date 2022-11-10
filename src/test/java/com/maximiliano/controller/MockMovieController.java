package com.maximiliano.controller;

import java.util.ArrayList;
import java.util.List;

import com.maximiliano.models.Movie;

public class MockMovieController {

    static List<Movie> movies = new ArrayList<Movie>();

    public static Movie createMovie(String title, String description, String genre) {
		Movie movie = new Movie();

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setGenre(genre);

		movies.add(movie);

		return movie;
	}

    public static List<Movie> listMovies() {
        return movies;
    }

    public static void deleteMovie(String id) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                movies.remove(movie);
                break;
            }
        }
    }

    public static Movie findMovie(String id) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    public static void updateMovie(String id, String title, String description, String genre) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                movie.setTitle(title);
                movie.setDescription(description);
                movie.setGenre(genre);
                break;
            }
        }
    }


}
