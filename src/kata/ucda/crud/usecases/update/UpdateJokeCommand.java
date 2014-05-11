package kata.ucda.crud.usecases.update;

import kata.ucda.crud.JokeStore;
import kata.ucda.crud.entities.Joke;
import kata.ucda.crud.entities.JokeBuilder;
import kata.ucda.crud.usecases.ModifyJokeCommand;

public class UpdateJokeCommand extends ModifyJokeCommand {
    private UpdateJokeRequest request;
    private UpdateJokeReceiver receiver;

    public UpdateJokeCommand(UpdateJokeRequest request, UpdateJokeReceiver receiver, JokeStore store) {
        super(store, request, receiver);
        this.request = request;
        this.receiver = receiver;
    }

    public JokeBuilder modificationBuilder() {
        return store.read(request.id()).update();
    }

    protected void saveJoke(Joke joke) {
        super.saveJoke(joke);
        receiver.updated();
    }
}
