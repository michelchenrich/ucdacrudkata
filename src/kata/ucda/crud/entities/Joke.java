package kata.ucda.crud.entities;

public abstract class Joke {
    public abstract String id();
    public abstract String author();
    public abstract String title();
    public abstract String text();

    public boolean isValid() {
        return !(authorIsEmpty() || titleIsEmpty() || textIsEmpty());
    }

    public void sendErrors(JokeValidationMessenger messenger) {
        if (authorIsEmpty()) messenger.authorIsEmpty();
        if (titleIsEmpty()) messenger.titleIsEmpty();
        if (textIsEmpty()) messenger.textIsEmpty();
    }

    private boolean textIsEmpty() {
        return text() == null || text().isEmpty();
    }

    private boolean titleIsEmpty() {
        return title() == null || title().isEmpty();
    }

    private boolean authorIsEmpty() {
        return author() == null || author().isEmpty();
    }

    public abstract JokeBuilder update();
}
