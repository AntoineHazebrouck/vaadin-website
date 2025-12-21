package antoine.vaadin_website.components.pages;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.contact.components.AudioDialog;
import antoine.vaadin_website.views.contact.components.DrawingsDialog;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class AboutMePage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Button listen = button(event -> new AudioDialog().open());
    private final Button see = button(event -> new DrawingsDialog().open());

    @Override
    protected Page initContent() {
        var page = new Page().title("About me").body(information());

        return page;
    }

    private Accordion information() {
        Accordion accordion = new Accordion();
        AccordionPanel skills = new AccordionPanel(
            "Skills",
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
        AccordionPanel hobbies = new AccordionPanel(
            "Hobbies",
            Responsive.column(
                Responsive.row(
                    new Span("Music : guitar, bass, composition"),
                    listen
                )
                    .wrap()
                    .build(),
                Responsive.row(new Span("Drawing"), see).wrap().build(),
                new Span("IoT : RaspberryPi")
            ).build()
        );
        AccordionPanel personnalInformation = new AccordionPanel(
            "Personal information",
            Responsive.column(
                new Span("+33 6 51 73 08 05"),
                new Span("antoine.hazebrouck5@gmail.com"),
                new Span("LinkedIn TODO"),
                new Span("59000, Lille"),
                new Span("French driving license + car")
            ).build()
        );

        accordion.add(skills);
        accordion.add(hobbies);
        accordion.add(personnalInformation);
        // TODO add soft skills

        return accordion;
    }

    private UnorderedList list(String... text) {
        var list = new UnorderedList();
        list.getStyle().setMargin("0");
        for (String string : text) {
            list.add(new ListItem(string));
        }
        return list;
    }

    private Button button(ComponentEventListener<ClickEvent<Button>> handler) {
        var button = new Button("", handler);

        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        return button;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        listen.setText(getTranslation("contact.information.listen"));
        see.setText(getTranslation("contact.information.see"));
    }
}
