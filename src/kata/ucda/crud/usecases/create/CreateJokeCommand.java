package kata.ucda.crud.usecases.create;

import kata.ucda.crud.JokeStore;
import kata.ucda.crud.entities.Joke;
import kata.ucda.crud.entities.JokeBuilder;
import kata.ucda.crud.usecases.ModifyJokeCommand;
import kata.ucda.crud.usecases.ModifyJokeRequest;

class CreateJokeCommand extends ModifyJokeCommand {
    private CreateJokeReceiver receiver;

    public CreateJokeCommand(ModifyJokeRequest request, CreateJokeReceiver receiver, JokeStore store) {
        super(store, request, receiver);
        this.receiver = receiver;
    }

    protected JokeBuilder modificationBuilder() {
        return store.create();
    }

    protected void saveJoke(Joke joke) {
        super.saveJoke(joke);
        receiver.createdWithId(joke.id());
    }
}
