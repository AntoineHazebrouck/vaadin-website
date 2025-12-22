package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;

public class AboutMePage extends Composite<Page> {

    @Override
    protected Page initContent() {
        var page = new Page().title(new Text("About me")).body(information());

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
}
