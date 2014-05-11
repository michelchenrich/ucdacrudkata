package kata.ucda.crud.usecases.update;

import kata.ucda.crud.entities.JokeValidationMessenger;

public interface UpdateJokeReceiver extends JokeValidationMessenger {
    void updated();
}
