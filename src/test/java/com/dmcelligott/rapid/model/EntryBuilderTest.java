package com.dmcelligott.rapid.model;

import org.junit.Assert;
import org.junit.Test;

import com.dmcelligott.rapid.model.Entry;
import com.dmcelligott.rapid.model.entry.Note;
import com.dmcelligott.rapid.model.entry.Task;

public class EntryBuilderTest {

	@Test
	public void entryBuilder_noteEntryWithNoteAsSubEntry_subEntryShouldBeNoteEntry()
			throws Exception {
		Entry noteSubEntry = new Entry().builder()
				.withNote(new Note("The project is under budget")).build();
		Entry<Note> noteEntry = new Entry().builder()
				.withNote(new Note("The project status"))
				.withSubEntry(noteSubEntry).build();
		
		System.out.println(noteEntry);
		Assert.assertTrue(Note.class.isInstance(noteEntry.getSubEntries().get(0).getContent()));
	}

	@Test
	public void entryBuilder_noteEntryWithTaskAsSubEntry_subEntryShouldBeTaskEntry() throws Exception {
		Entry taskSubEntry = new Entry().builder()
				.withTask(new Task("The project is under budget")).build();
		Entry<Note> noteEntry = new Entry().builder()
				.withNote(new Note("The project status"))
				.withSubEntry(taskSubEntry).build();

		System.out.println(noteEntry);
		Assert.assertTrue(Task.class.isInstance(noteEntry.getSubEntries().get(0).getContent()));
	}

	@Test
	public void entryBuilder_noteEntryWithNoteAndTaskSubEntries_shouldHaveTwoSubEntries()
			throws Exception {
		Entry noteSubEntry = new Entry().builder()
				.withNote(new Note("The project is under budget")).build();

		Entry taskSubEntry = new Entry().builder()
				.withTask(new Task("The project is under budget")).build();

		Entry<Note> noteEntry = new Entry().builder()
				.withNote(new Note("The project status"))
				.withSubEntry(noteSubEntry).withSubEntry(taskSubEntry).build();
		
		System.out.println(noteEntry);
		Assert.assertEquals(2, noteEntry.getSubEntries().size());
		Assert.assertTrue(Note.class.isInstance(noteEntry.getSubEntries().get(0).getContent()));
		Assert.assertTrue(Task.class.isInstance(noteEntry.getSubEntries().get(1).getContent()));
	}

}
