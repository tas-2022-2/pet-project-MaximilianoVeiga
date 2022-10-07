package com.maximiliano;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maximiliano.model.Movie;

public class MovieTest {
    
    @Test
	public void createMovie() {
		Movie movie1 = new Movie();

        movie1.setTitle("The Godfather 2");
        movie1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie1.setGenre("Crime");

        String expected = "Movie [id=" + movie1.getId()
			+ ", title=The Godfather 2, description=The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son., genre=Crime]";

        assertEquals(expected, movie1.toString());
    }

    @Test
    public void updateMovie() {
        Movie movie1 = new Movie();
        
        movie1.setTitle("The Godfather 4");
        movie1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie1.setGenre("Crime");

        movie1.setTitle("The Father 4 - HD");
        movie1.setDescription("Clandestine empire to his reluctant son.");
        movie1.setGenre("Crime");

        String expected = "Movie [id=" + movie1.getId() 
            + ", title=The Father 4 - HD, description=Clandestine empire to his reluctant son., genre=Crime]";

        assertEquals(expected, movie1.toString());
    }
}
