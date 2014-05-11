package kata.ucda.crud.usecases.create;

import kata.ucda.crud.usecases.ModifyJokeTest;

public class CreateJokeTest extends ModifyJokeTest {
    protected void whenExecutingCommand() {
        new CreateJokeCommand(handler, handler, handler).execute();
    }
}