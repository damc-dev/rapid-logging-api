package com.dmcelligott.rapid.util;

import com.dmcelligott.rapid.model.Entry;

public class Builder<T> {

	private Entry<T> entryInstance;

	public Entry<T> getEntryInstance() {
		return entryInstance;
	}

	public void setEntryInstance(Entry<T> entryInstance) {
		this.entryInstance = entryInstance;
	}
	
	public Builder<T> withUri(String uri) {
		entryInstance.setUri(uri);
		return this;
	}

	public Builder<T> withSubEntry(Entry<T> subEntry) {
		entryInstance.addEntry(subEntry);
		return this;
	}

	public Entry<T> build() {
		return entryInstance;
	}

}
