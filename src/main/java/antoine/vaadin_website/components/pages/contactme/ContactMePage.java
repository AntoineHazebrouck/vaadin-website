package antoine.vaadin_website.components.pages.contactme;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class ContactMePage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");

    @Override
    protected Page initContent() {
        var page = new Page().title(title).body(new ContactForm());

        return page;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("contact.title"));
    }
}
