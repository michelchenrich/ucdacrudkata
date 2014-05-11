package kata.ucda.crud.entities;

public class FakeJoke extends Joke implements JokeBuilder {
    private String id;
    private String author;
    private String title;
    private String text;

    public FakeJoke(String id) {
        this.id = id;
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

    public JokeBuilder update() {
        return new FakeJoke(id);
    }

    public JokeBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public JokeBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public JokeBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public Joke build() {
        return this;
    }
}
