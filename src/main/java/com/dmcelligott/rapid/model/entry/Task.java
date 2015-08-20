package com.dmcelligott.rapid.model.entry;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class Task {
	private String title;
	private String description;
	private boolean isCompleted;

	public Task() {
	}
	
	public Task(String title) {
		this.title = title;
	}

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Task(String title, String description, boolean isCompleted) {
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
