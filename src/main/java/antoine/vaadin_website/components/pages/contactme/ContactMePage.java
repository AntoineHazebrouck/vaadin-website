package antoine.vaadin_website.components.pages.contactme;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;

public class ContactMePage extends Composite<Page> {

    @Override
    protected Page initContent() {
        var page = new Page()
            .title(new Text("Contact me"))
            .body(new ContactForm());

        return page;
    }
}
