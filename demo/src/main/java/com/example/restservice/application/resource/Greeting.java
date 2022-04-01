package com.example.restservice.application.resource;

import java.io.Serializable;

import lombok.Data;

@Data
public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;

	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
