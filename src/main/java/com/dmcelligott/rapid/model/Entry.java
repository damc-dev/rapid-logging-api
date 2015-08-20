package com.dmcelligott.rapid.model;

import java.util.ArrayList;
import java.util.List;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.dmcelligott.rapid.model.entry.Event;
import com.dmcelligott.rapid.model.entry.Note;
import com.dmcelligott.rapid.model.entry.Task;

@AutoProperty
public class Entry<T> {

	private T content;
	private String uri;
	private List<Entry<T>> subEntries;
	
	public Entry() {
		this.subEntries = new ArrayList<Entry<T>>();
	}
	
	public Entry(T content) {
		this.content = content;
		this.subEntries = new ArrayList<Entry<T>>();
	}

	public Entry(T content, String uri) {
		this.content = content;
		this.uri = uri;
		this.subEntries = new ArrayList<Entry<T>>();
	}

	public Entry(T content, String uri, List<Entry<T>> subEntries) {
		this.content = content;
		this.uri = uri;
		this.subEntries = subEntries;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Entry<T>> getSubEntries() {
		return subEntries;
	}

	public void setSubEntries(List<Entry<T>> subEntries) {
		this.subEntries = subEntries;
	}

	public void addEntry(Entry<T> subEntry) {
		subEntries.add(subEntry);
	}

	public static Builder builder() {
		return new Entry.Builder();
	}

	public static class Builder {
		private Entry instance = new Entry();

		public Entry build() {
			return instance;
		}

		public Builder withNote(Note note) {
			instance.content = note;
			return this;
		}

		public Builder withTask(Task task) {
			instance.content = task;
			return this;
		}

		public Builder withEvent(Event event) {
			instance.content = event;
			return this;
		}

		public Builder withUri(String uri) {
			instance.uri = uri;
			return this;
		}

		public Builder withSubEntry(Entry subEntry) {
			instance.addEntry(subEntry);
			return this;
		}
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