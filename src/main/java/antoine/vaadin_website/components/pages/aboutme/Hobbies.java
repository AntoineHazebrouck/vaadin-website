package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.contact.components.AudioDialog;
import antoine.vaadin_website.views.contact.components.DrawingsDialog;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class Hobbies
    extends Composite<AccordionPanel>
    implements LocaleChangeObserver, LayoutMixin {

    private final Button listen = button(event -> new AudioDialog().open());
    private final Button see = button(event -> new DrawingsDialog().open());

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
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
            )
                .withoutSpacing()
                .build()
        );
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
