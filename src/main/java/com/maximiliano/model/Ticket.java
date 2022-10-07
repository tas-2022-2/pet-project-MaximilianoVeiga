package com.maximiliano.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.UuidGenerator;

@UuidGenerator(name = "id")
@Entity(name = "ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id")
	private String id;

	@Column(nullable = false)
	@Size(min = 1, max = 255)
	@NotNull(message = "Client name cannot be null")
	private String clientName;

	@Column(nullable = false)
	@Size(min = 1, max = 255)
	@NotNull(message = "Seat name cannot be null")
	private String seat;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "session_id")
	private Session session;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", clientName=" + clientName + ", seat=" + seat + ", session=" + session + "]";
	}

};
