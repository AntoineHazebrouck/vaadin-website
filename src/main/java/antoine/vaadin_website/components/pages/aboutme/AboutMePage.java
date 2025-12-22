package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class AboutMePage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");

    @Override
    protected Page initContent() {
        var page = new Page().title(title).body(information());

        return page;
    }

    private Accordion information() {
        Accordion accordion = new Accordion();

        accordion.add(new HardSkills().getContent());
        accordion.add(new SoftSkills().getContent());
        accordion.add(new Hobbies().getContent());
        accordion.add(new PersonalInformation().getContent());

        return accordion;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("about.title"));
    }
}
