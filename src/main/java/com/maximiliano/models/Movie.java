package com.maximiliano.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.UuidGenerator;

@UuidGenerator(name = "id")
@Entity(name = "movie")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id")
	private String id;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Title cannot be null")
	@Size(min = 1, max = 255)
	private String title;

	@Column(nullable = false)
	@NotNull(message = "Description cannot be null")
	@Size(min = 1, max = 500)
	private String description;

	@Column(nullable = false)
	@NotNull(message = "Genre cannot be null")
	@Size(min = 1, max = 255)
	private String genre;

	public Movie () {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", genre=" + genre + "]";
	}
	
};
