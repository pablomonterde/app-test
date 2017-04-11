package com.agiletdd.application.domain;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Access(AccessType.FIELD)
public class User {

	private static final int MIN_NAME_LENGTH = 3;

	@Id
	private UUID id;

	@Column()
	private String name;

	private User() {
	}

	public User(String name) {
		if (name.length() < MIN_NAME_LENGTH)
			throw new InvalidUserParameterException("User name must be greater than 3");

		this.id = UUID.randomUUID();
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
