package kata.ucda.crud.usecases;

import kata.ucda.crud.JokeStore;
import kata.ucda.crud.entities.Joke;
import kata.ucda.crud.entities.JokeBuilder;
import kata.ucda.crud.entities.JokeValidationMessenger;

public abstract class ModifyJokeCommand implements Cpmmand {
    protected JokeStore store;
    protected ModifyJokeRequest request;
    private JokeValidationMessenger messenger;

    public ModifyJokeCommand(JokeStore store, ModifyJokeRequest request, JokeValidationMessenger messenger) {
        this.store = store;
        this.request = request;
        this.messenger = messenger;
    }

    public final void execute() {
        Joke joke = buildFromRequest(modificationBuilder());
        if (joke.isValid()) saveJoke(joke);
        else joke.sendErrors(messenger);
    }

    protected abstract JokeBuilder modificationBuilder();

    protected void saveJoke(Joke joke) {
        store.save(joke);
    }

    private Joke buildFromRequest(JokeBuilder builder) {
        return builder.withAuthor(request.author()).withTitle(request.title()).withText(request.text()).build();
    }
}
