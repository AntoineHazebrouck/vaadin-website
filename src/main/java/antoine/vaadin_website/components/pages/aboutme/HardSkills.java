package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class HardSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin, LocaleChangeObserver {

    private final Text title = new Text("");
    private final Paragraph intro = new Paragraph();

    
    private final Text testing = new Text("");
    private final Text devOps = new Text("");

    @Override
    protected AccordionPanel initContent() {
        Component col = Responsive.column(
            intro,
            new GatheringUserNeeds(),
            new UserInterfaces(),
            new Backends(),
            new DataSkills(),
            new AccordionPanel(
                testing,
                list(
                    "Test Driven Development",
                    "Behavior Driven Development (Gherkin)",
                    "Unit tests, integration tests, UI tests"
                )
            ),
            new AccordionPanel(
                devOps,
                list("Jenkins/Github Actions", "Docker", "AWS", "Linux")
            )
        )
            .padding("0 var(--lumo-space-m) 0 var(--lumo-space-m)")
            .withoutSpacing()
            .build();

        col.getStyle().setPaddingTop(null);
        return new AccordionPanel(title, col);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("about.hard-skills.title"));
        intro.setText(getTranslation("about.hard-skills.intro"));
        testing.setText(getTranslation("about.hard-skills.testing"));
        devOps.setText(getTranslation("about.hard-skills.devops"));
    }
}
