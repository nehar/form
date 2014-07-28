package controllers;

import models.Entry;
import play.data.Form;
import play.mvc.*;
import views.html.*;



import static play.data.Form.form;

public class Application extends Controller {

    final static Form<Entry> entryForm = form(Entry.class);

    public static Result index() {

        return ok(index.render(entryForm));
    }
    @play.db.jpa.Transactional
    public static Result submit() {
        Form<Entry> filledForm = entryForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(index.render(filledForm));
        } else {

            Entry created = filledForm.get();

            created.save();
            return ok(submit.render(created));
        }
    }
}
