package kata.ucda.crud.entities;

public interface JokeBuilder {
    JokeBuilder withAuthor(String author);
    JokeBuilder withTitle(String title);
    JokeBuilder withText(String text);
    Joke build();
}
