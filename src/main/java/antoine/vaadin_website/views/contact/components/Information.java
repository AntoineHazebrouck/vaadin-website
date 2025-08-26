package antoine.vaadin_website.views.contact.components;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasText.WhiteSpace;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class Information
    extends Composite<VerticalLayout>
    implements LocaleChangeObserver {

    Button listen = button(event -> new AudioDialog().open());
    Button see = button(event -> new DrawingsDialog().open());

    H3 informationTitle = new H3();
    H3 hobbiesTitle = new H3();

    H5 keyCity = label();
    Span valueCity = new Span();

    H5 keyMusic = label();
    Span valueMusic = new Span();

    H5 keyDrawing = label();

    H5 keyVideoGames = label();
    Span valueVideoGames = new Span();

    Component col1 = Responsive.column(
        Responsive.row(keyCity, valueCity)
            .alignement(Alignment.CENTER)
            .wrap()
            .build(),
        Responsive.row(
            label("Email : "),
            new Span("antoine.hazebrouck5@gmail.com")
        )
            .alignement(Alignment.CENTER)
            .wrap()
            .build()
    ).build();

    Component col2 = Responsive.column(
        Responsive.row(keyMusic, valueMusic, listen)
            .alignement(Alignment.CENTER)
            .wrap()
            .build(),
        Responsive.row(keyDrawing, see)
            .alignement(Alignment.CENTER)
            .wrap()
            .build(),
        Responsive.row(keyVideoGames, valueVideoGames)
            .alignement(Alignment.CENTER)
            .wrap()
            .build()
    ).build();

    private Button button(ComponentEventListener<ClickEvent<Button>> handler) {
        var button = new Button("", handler);

        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        return button;
    }

    @Override
    protected VerticalLayout initContent() {
        return (VerticalLayout) Responsive.column(
            informationTitle,
            col1,
            hobbiesTitle,
            col2
        ).build();
    }

    private static H5 label() {
        var label = new H5();
        label.setWhiteSpace(WhiteSpace.NOWRAP);
        return label;
    }

    private static H5 label(String text) {
        var label = new H5(text);
        label.setWhiteSpace(WhiteSpace.NOWRAP);
        return label;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        informationTitle.setText(
            getTranslation("contact.information.information-title")
        );
        hobbiesTitle.setText(
            getTranslation("contact.information.hobbies-title")
        );

        listen.setText(getTranslation("contact.information.listen"));
        see.setText(getTranslation("contact.information.see"));

        keyCity.setText(
            getTranslation("contact.information.keys.city") + " : "
        );
        valueCity.setText(getTranslation("contact.information.values.city"));

        keyMusic.setText(
            getTranslation("contact.information.keys.music") + " : "
        );
        valueMusic.setText(getTranslation("contact.information.values.music"));

        keyDrawing.setText(getTranslation("contact.information.keys.drawing"));

        keyVideoGames.setText(
            getTranslation("contact.information.keys.video-games") + " : "
        );
        valueVideoGames.setText(
            getTranslation("contact.information.values.video-games")
        );
    }
}
