package com.dmcelligott.rapid.model.entry;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class Note {

	private String title;
	private String body;

	public Note() {
	}
	
	public Note(String title) {
		this.title = title;
	}

	public Note(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Note withTitle(String title) {
		this.title = title;
		return new Note(title, body);
	}

	public Note withBody(String body) {
		this.body = body;
		return new Note(title, body);
	}

	@Override
	public boolean equals(Object o) {
		return Pojomatic.equals(this, o);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}

}
