package kata.ucda.crud.usecases.create;

import kata.ucda.crud.entities.JokeValidationMessenger;

public interface CreateJokeReceiver extends JokeValidationMessenger {
    void createdWithId(String id);
}
