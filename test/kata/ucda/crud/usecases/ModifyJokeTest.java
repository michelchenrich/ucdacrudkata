package kata.ucda.crud.usecases;

import org.junit.Test;

public abstract class ModifyJokeTest {
    protected FakeJokeHandler handler;

    protected void givenAttributes(String id, String author, String title, String text) {
        handler = new FakeJokeHandler(id, author, title, text);
    }

    protected void givenAttributes(String author, String title, String text) {
        givenAttributes("existent", author, title, text);
    }

    protected abstract void whenExecutingCommand();

    protected void thenShouldPersistAttributes() {
        handler.assertSavedAttributes();
    }

    protected void badRequestShouldReturnError(String author, String title, String text, String... messages) {
        givenAttributes(author, title, text);
        whenExecutingCommand();
        thenShouldSendMessages(messages);
    }

    private void thenShouldSendMessages(String... messages) {
        handler.assertReceivedMessages(messages);
    }

    @Test
    public void goodRequestShouldCreateJoke() {
        givenAttributes("Author", "Title", "Text");
        whenExecutingCommand();
        thenShouldPersistAttributes();
    }

    @Test
    public void badRequestShouldReturnError_author() {
        badRequestShouldReturnError("", "Title", "Text", "authorIsEmpty");
        badRequestShouldReturnError(null, "Title", "Text", "authorIsEmpty");
    }

    @Test
    public void badRequestShouldReturnError_title() {
        badRequestShouldReturnError("Author", "", "Text", "titleIsEmpty");
        badRequestShouldReturnError("Author", null, "Text", "titleIsEmpty");
    }

    @Test
    public void badRequestShouldReturnError_text() {
        badRequestShouldReturnError("Author", "Title", "", "textIsEmpty");
        badRequestShouldReturnError("Author", "Title", null, "textIsEmpty");
    }

    @Test
    public void badRequestShouldReturnMultipleErrors() {
        badRequestShouldReturnError("", null, "", "authorIsEmpty", "titleIsEmpty", "textIsEmpty");
    }
}
