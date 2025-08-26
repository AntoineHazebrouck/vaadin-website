package antoine.vaadin_website.views.contact;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.views.contact.components.ContactForm;
import antoine.vaadin_website.views.contact.components.Information;
import antoine.vaadin_website.views.experiences.ExperiencesView;
import antoine.vaadin_website.views.main.MainView;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.springframework.mail.javamail.JavaMailSender;

@Route("contact")
public class ContactView extends Page implements LocaleChangeObserver {

    H1 title = new H1();

    public ContactView(JavaMailSender emails) {
        add(title);
        add(new ContactForm(emails));
        add(new Information());
    }

    @Override
    public Class<? extends Component> previous() {
        return MainView.class;
    }

    @Override
    public Class<? extends Component> next() {
        return ExperiencesView.class;
    }

    @Override
    public String getPageTitle() {
        return getTranslation("contact.page-title");
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("contact.title"));
    }
}
