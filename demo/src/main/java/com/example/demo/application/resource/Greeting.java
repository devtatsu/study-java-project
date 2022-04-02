package com.example.demo.application.resource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Greeting {

	@Getter
	@Setter
	// private final long id;
	public long id;

	@Getter
	@Setter
	// private final String content;
	public String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	// public long getId() {
	// return id;
	// }

	// public String getContent() {
	// return content;
	// }

	public Greeting() {
	}

}
