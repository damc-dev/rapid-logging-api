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
	private String contentType;
	private List<Entry<T>> subEntries;

	public Entry() {
		this.subEntries = new ArrayList<Entry<T>>();
	}

	public Entry(T content) {
		this.content = content;
		this.contentType = getContentType(content);
		this.subEntries = new ArrayList<Entry<T>>();
	}

	public Entry(T content, String uri) {
		this.content = content;
		this.uri = uri;
		this.contentType = getContentType(content);
		this.subEntries = new ArrayList<Entry<T>>();
	}

	public Entry(T content, String uri, List<Entry<T>> subEntries) {
		this.content = content;
		this.uri = uri;
		this.contentType = getContentType(content);
		this.subEntries = subEntries;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
		this.contentType = getContentType(content);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static class Builder {
		private Entry instance = new Entry();

		public Entry build() {
			return instance;
		}

		public Builder withNote(Note note) {
			instance.setContent(note);
			return this;
		}

		public Builder withTask(Task task) {
			instance.setContent(task);
			return this;
		}

		public Builder withEvent(Event event) {
			instance.setContent(event);
			return this;
		}

		public Builder withUri(String uri) {
			instance.setUri(uri);
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private String getContentType(T content) {
		return content.getClass().getSimpleName();
	}

}