package com.dmcelligott.rapid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmcelligott.rapid.dao.NoteDao;
import com.dmcelligott.rapid.model.Entry;
import com.dmcelligott.rapid.model.entry.Note;
import com.dmcelligott.rapid.model.entry.Task;

@Service
public class EntryService {

	List<Entry> entries = new ArrayList<Entry>();

	public EntryService() {
		Entry<Note> noteSubEntry = Entry.builder()
				.withNote(new Note("The project is under budget")).build();

		Entry<Task> taskSubEntry = Entry.builder()
				.withTask(new Task("The project is under budget")).build();

		Entry<Note> noteEntry = Entry.builder()
				.withNote(new Note("The project status"))
				.withSubEntry(noteSubEntry).withSubEntry(taskSubEntry).build();
		
		entries.add(noteEntry);
	}

	public Iterable<Entry> findAll() {

		return entries;
	}

	public Entry<Note> saveNote(Note note) {
		Entry<Note> noteEntry = new Entry<Note>(note);
		return null;
	}

}
