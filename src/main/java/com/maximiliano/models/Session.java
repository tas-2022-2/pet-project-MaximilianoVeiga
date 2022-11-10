package com.maximiliano.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.UuidGenerator;

import com.maximiliano.utils.Time;

@UuidGenerator(name = "id")
@Entity(name = "session")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id")
	private String id;

	@Column(nullable = false)
	@NotNull(message = "Timestamp cannot be null")
	private Timestamp timestamp;

	@OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
	private List<Ticket> tickets;

	@ManyToOne(optional = false)
	@NotNull(message = "Room cannot be null")
	@JoinColumn(name = "room_id")
	private Room room;

	@ManyToOne(optional = false)
	@NotNull(message = "Movie cannot be null")
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Transient
	private int availableSeats;

	public Session () {
		this.id = UUID.randomUUID().toString();
		this.tickets = new ArrayList<Ticket>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", timestamp=" + Time.toString(timestamp) + ", tickets=" + tickets + ", room=" + room + ", movie="
				+ movie + "]";
	}

};
