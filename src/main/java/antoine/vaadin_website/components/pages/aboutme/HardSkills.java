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

    private final Text userInterfaces = new Text("");
    private final Text backends = new Text("");
    private final Text data = new Text("");
    private final Text testing = new Text("");
    private final Text devOps = new Text("");

    @Override
    protected AccordionPanel initContent() {
        Component col = Responsive.column(
            intro,
            new GatheringUserNeeds(),
            new AccordionPanel(
                userInterfaces,
                list(
                    "single page applications with Angular/React/Vaadin",
                    "multi page applications with JSP/Thymeleaf",
                    "desktop apps with Java",
                    "mobile apps with Flutter"
                )
            ),
            new AccordionPanel(
                backends,
                list(
                    "RESTful APIs",
                    "Sockets",
                    "Spring Data ORM",
                    "Spring Security",
                    "Legacy maintenance",
                    "Software architecture"
                )
            ),
            new AccordionPanel(
                data,
                list(
                    "Hadoop/Spark",
                    "Spring Batch",
                    "Pandas",
                    "Relational databases",
                    "Distributed databases"
                )
            ),
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
                list("Jenkins/Github Actions", "Docker", "AWS")
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

        userInterfaces.setText(
            getTranslation("about.hard-skills.user-interfaces")
        );
        backends.setText(getTranslation("about.hard-skills.backends"));
        data.setText(getTranslation("about.hard-skills.data"));
        testing.setText(getTranslation("about.hard-skills.testing"));
        devOps.setText(getTranslation("about.hard-skills.devops"));
    }
}
