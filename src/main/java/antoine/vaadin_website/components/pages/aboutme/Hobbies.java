package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.components.SongsDialog;
import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class Hobbies
    extends Composite<AccordionPanel>
    implements LocaleChangeObserver, LayoutMixin {

    private final Button listen = button(event -> new SongsDialog().open());
    // private final Button see = button(event -> new DrawingsDialog().open());

    private final Text title = new Text("");
    private final Text music = new Text("");
    private final Text drawing = new Text("");
    private final Text iot = new Text("");

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            title,
            Responsive.column(
                Responsive.row(new Span(music), listen).wrap().build(),
                Responsive.row(new Span(drawing)).wrap().build(),
                new Span(iot)
            )
                .padding("0 var(--lumo-space-m) 0 var(--lumo-space-m)")
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
        listen.setText(getTranslation("about.hobbies.listen"));
        // see.setText(getTranslation("about.hobbies.see"));
        title.setText(getTranslation("about.hobbies.title"));
        music.setText(getTranslation("about.hobbies.music"));
        drawing.setText(getTranslation("about.hobbies.drawing"));
        iot.setText(getTranslation("about.hobbies.iot"));
    }
}
