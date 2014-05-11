package kata.ucda.crud;

import kata.ucda.crud.entities.Joke;
import kata.ucda.crud.entities.JokeBuilder;

public interface JokeStore {
    void save(Joke joke);
    JokeBuilder create();
    Joke read(String id) throws EntityNotFoundException;
}
