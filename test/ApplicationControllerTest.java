
import models.Entry;
import org.junit.Test;
import play.data.Form;
import play.twirl.api.Content;

import static org.fest.assertions.Assertions.assertThat;
import static play.data.Form.form;
import static play.test.Helpers.*;

public class ApplicationControllerTest {

    @Test
    public void renderTemplate() {
        running(fakeApplication(), new Runnable() {
                    public void run() {
        Form<Entry> entryForm = form(Entry.class);
        Content html = views.html.index.render(entryForm);
        assertThat(contentAsString(html)).contains("My Form");
                    }
        });
    }
}

