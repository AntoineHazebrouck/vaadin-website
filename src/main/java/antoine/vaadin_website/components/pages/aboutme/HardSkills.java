package antoine.vaadin_website.components.pages.aboutme;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;

public class HardSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin, LocaleChangeObserver {

    private final Text title = new Text("");
    private final Paragraph intro = new Paragraph();

    private final Text testing = new Text("");
    private final Text devOps = new Text("");

    @Override
    protected AccordionPanel initContent() {
        var accordion = new Accordion();
        accordion.add(new GatheringUserNeeds().getContent());
        accordion.add(new UserInterfaces().getContent());
        accordion.add(new Backends().getContent());
        accordion.add(new DataSkills().getContent());
        accordion.add(
            new AccordionPanel(
                testing,
                list(
                    "Test Driven Development",
                    "Behavior Driven Development (Gherkin)",
                    "Unit tests, integration tests, UI tests"
                )
            )
        );
        accordion.add(
            new AccordionPanel(
                devOps,
                list("Jenkins/Github Actions", "Docker", "AWS", "Linux")
            )
        );
        accordion.getStyle().setPaddingTop(null);

        accordion.close();

        return new AccordionPanel(
            new H5(title),
            Responsive.column(intro, accordion)
                .padding("0 var(--lumo-space-m) 0 var(--lumo-space-m)")
                .withoutSpacing()
                .build()
        );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("about.hard-skills.title"));
        intro.setText(getTranslation("about.hard-skills.intro"));
        testing.setText(getTranslation("about.hard-skills.testing"));
        devOps.setText(getTranslation("about.hard-skills.devops"));
    }
}
