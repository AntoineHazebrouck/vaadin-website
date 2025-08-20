package antoine.vaadin_website.views.contact;

import antoine.vaadin_website.components.Information;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.views.MainView;
import antoine.vaadin_website.views.contact.components.ContactForm;
import antoine.vaadin_website.views.experiences.ExperiencesView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.springframework.mail.javamail.JavaMailSender;

@Route("contact")
public class ContactView extends Page {

    public ContactView(JavaMailSender emails) {
        add(new H1("Me contacter"));
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
}
