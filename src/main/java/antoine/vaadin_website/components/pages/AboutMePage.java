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
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class AboutMePage
    extends Composite<Page>
    implements LocaleChangeObserver {

    Button listen = button(event -> new AudioDialog().open());
    Button see = button(event -> new DrawingsDialog().open());

    @Override
    protected Page initContent() {
        var page = new Page().title("About me").body(information());

        return page;
    }

    private Accordion information() {
        Accordion accordion = new Accordion();
        AccordionPanel skills = new AccordionPanel(
            "Skills",
            Responsive.column(new Span("TODO")).build()
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
                new Span("59000, Lille")
            ).build()
        );

        accordion.add(skills);
        accordion.add(hobbies);
        accordion.add(personnalInformation);

        return accordion;
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
