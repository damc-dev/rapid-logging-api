package com.dmcelligott.rapid.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.dmcelligott.rapid.model.Entry;
import com.dmcelligott.rapid.model.entry.Note;
import com.dmcelligott.rapid.model.entry.Task;

@Service
public class EntryService {

	public Iterable<Entry> findAll() {
		Entry<Note> noteSubEntry = Entry.builder()
				.withNote(new Note("The project is under budget")).build();

		Entry<Task> taskSubEntry = Entry.builder()
				.withTask(new Task("The project is under budget")).build();

		Entry<Note> noteEntry = Entry.builder()
				.withNote(new Note("The project status"))
				.withSubEntry(noteSubEntry).withSubEntry(taskSubEntry).build();		
		return Arrays.asList(noteEntry);
	}

}
