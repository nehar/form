import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import play.mvc.Result;
import play.test.FakeRequest;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

public class ApplicationTest {

    @Test
    public void callIndex() {
        running(fakeApplication(), new Runnable() {
            public void run() {

                Result result = callAction(controllers.routes.ref.Application.index());
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentType(result)).isEqualTo("text/html");
                assertThat(charset(result)).isEqualTo("utf-8");
                assertThat(contentAsString(result)).contains("My Form");

            }
        });
    }


    @Test
    public void callSubmit() {

        running(fakeApplication(), new Runnable() {
            public void run() {
                Result result = callAction(controllers.routes.ref.Application.submit(), new FakeRequest().withFormUrlEncodedBody(ImmutableMap.of("imie", "asd", "nazwisko", "bbb", "data", "2014-10-23", "email", "sa@fsa.pl", "database", "1")));
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentAsString(result)).contains("Entry added to database:");
            }
        });
    }

    @Test
    public void callBadSubmit() {

        running(fakeApplication(), new Runnable() {
            public void run() {
                Result result = callAction(controllers.routes.ref.Application.submit(), new FakeRequest().withFormUrlEncodedBody(ImmutableMap.of("imie", "asd", "nazwisko", "bbb", "data", "201410-23", "email", "safsa.pl", "database", "1")));
                assertThat(status(result)).isEqualTo(BAD_REQUEST);
            }
        });
    }
}