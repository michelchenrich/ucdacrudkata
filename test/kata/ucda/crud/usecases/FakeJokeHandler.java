package kata.ucda.crud.usecases;

import kata.ucda.crud.EntityNotFoundException;
import kata.ucda.crud.JokeStore;
import kata.ucda.crud.entities.FakeJoke;
import kata.ucda.crud.entities.Joke;
import kata.ucda.crud.entities.JokeBuilder;
import kata.ucda.crud.entities.JokeValidationMessenger;
import kata.ucda.crud.usecases.create.CreateJokeReceiver;
import kata.ucda.crud.usecases.update.UpdateJokeReceiver;
import kata.ucda.crud.usecases.update.UpdateJokeRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FakeJokeHandler implements JokeStore, JokeValidationMessenger, UpdateJokeRequest, CreateJokeReceiver, UpdateJokeReceiver {
    private String id;
    private String author;
    private String title;
    private String text;
    private String incrementalId = "0";
    private Joke savedJoke;
    private List<String> messages = new ArrayList<String>();
    private boolean jokeWasRead;

    public FakeJokeHandler(String id, String author, String title, String text) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
    }

    public String id() {
        return id;
    }

    public String author() {
        return author;
    }

    public String title() {
        return title;
    }

    public String text() {
        return text;
    }

    public void createdWithId(String id) {
        assertEquals(incrementalId, id);
    }

    public void authorIsEmpty() {
        messages.add("authorIsEmpty");
    }

    public void titleIsEmpty() {
        messages.add("titleIsEmpty");
    }

    public void textIsEmpty() {
        messages.add("textIsEmpty");
    }

    public void updated() {
        incrementalId = "existent";
    }

    public void save(Joke joke) {
        this.savedJoke = joke;
    }

    public void assertReadJoke() {
        assertTrue(jokeWasRead);
    }

    public void assertSavedAttributes() {
        assertNotNull(savedJoke);
        assertEquals(0, messages.size());
        assertEquals(incrementalId, savedJoke.id());
        assertEquals(author, savedJoke.author());
        assertEquals(title, savedJoke.title());
        assertEquals(text, savedJoke.text());
    }

    public JokeBuilder create() {
        incrementalId = String.valueOf(Integer.valueOf(incrementalId) + 1);
        return new FakeJoke(incrementalId);
    }

    public Joke read(String id) {
        if (!id.equals("existent")) throw new EntityNotFoundException();
        jokeWasRead = true;
        return new FakeJoke("existent");
    }

    public void assertReceivedMessages(String[] messages) {
        assertNull(savedJoke);
        assertArrayEquals(this.messages.toArray(), messages);
    }
}