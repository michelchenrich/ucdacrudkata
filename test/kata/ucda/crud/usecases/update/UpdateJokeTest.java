package kata.ucda.crud.usecases.update;

import kata.ucda.crud.EntityNotFoundException;
import kata.ucda.crud.usecases.ModifyJokeTest;
import org.junit.Test;

public class UpdateJokeTest extends ModifyJokeTest {
    protected void whenExecutingCommand() {
        new UpdateJokeCommand(handler, handler, handler).execute();
    }

    protected void thenShouldPersistAttributes() {
        handler.assertReadJoke();
        super.thenShouldPersistAttributes();
    }

    @Test(expected = EntityNotFoundException.class)
    public void unexistentIdShouldReturnError() {
        givenAttributes("unexistent", "Author", "Title", "Text");
        whenExecutingCommand();
        thenShouldPersistAttributes();
    }
}
