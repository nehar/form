import com.google.common.collect.ImmutableMap;
import controllers.Application;
import models.dao.EntryDao;
import org.junit.Before;
import org.junit.Test;
import play.mvc.Result;
import play.test.FakeRequest;

import static org.fest.assertions.Assertions.assertThat;

import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.data.Form.form;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.assertEquals;
import static play.test.Helpers.fakeApplication;

public class ApplicationTest {
    EntryDao entryDaoMock = mock(EntryDao.class);

    @Before
    public void setUp() {
        doNothing().when(entryDaoMock).persist(any());
        Application.setEntryDao(entryDaoMock);


        // In memory db will not be used for tests, however added here just
        // so it does not try to connect to db at all even to check connectivity.
        start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
    }

    @Test
    public void callIndex() {


                Result result = callAction(controllers.routes.ref.Application.index());
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentType(result)).isEqualTo("text/html");
                assertThat(charset(result)).isEqualTo("utf-8");
                assertThat(contentAsString(result)).contains("My Form");

    }


    @Test
    public void callSubmit() {


                Result result = callAction(controllers.routes.ref.Application.submit(), new FakeRequest().withFormUrlEncodedBody(ImmutableMap.of("imie", "aaaaab", "nazwisko", "bbb", "data", "2014-10-23", "email", "sa@fsa.pl", "database", "1")));
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentAsString(result)).contains("Entry added to database:");
    }

    @Test
    public void callBadSubmit() {


                Result result = callAction(controllers.routes.ref.Application.submit(), new FakeRequest().withFormUrlEncodedBody(ImmutableMap.of("imie", "asd", "nazwisko", "bbb", "data", "201410-23", "email", "safsa.pl", "database", "1")));
                assertThat(status(result)).isEqualTo(BAD_REQUEST);

    }
}