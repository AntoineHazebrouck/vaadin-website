package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;

public class HardSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin {

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            "Hard skills",
            Responsive.column(
                new AccordionPanel(
                    "User interfaces : Creating simple but effective UIs for all needs",
                    list(
                        "single page applications with Angular/React/Vaadin",
                        "multi page applications with JSP/Thymeleaf",
                        "desktop apps with Java",
                        "mobile apps with Flutter"
                    )
                ),
                new AccordionPanel(
                    "Backends : Server side computing with Java/Spring Boot",
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
                    "Data : Processing and storing data",
                    list(
                        "Hadoop/Spark",
                        "Spring Batch",
                        "Pandas",
                        "Relational databases",
                        "Distributed databases"
                    )
                ),
                new AccordionPanel(
                    "Testing : Ensuring proper testing to make my applications resilient",
                    list(
                        "Test Driven Development",
                        "Behavior Driven Development (Gherkin)",
                        "Unit tests, integration tests, UI tests"
                    )
                ),
                new AccordionPanel(
                    "DevOps : Safely shipping applications into users' hands",
                    list("Jenkins/Github Actions", "Docker", "AWS")
                )
            )
                .withoutSpacing()
                .build()
        );
    }
}
