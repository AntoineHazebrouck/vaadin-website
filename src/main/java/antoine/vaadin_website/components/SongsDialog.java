package antoine.vaadin_website.components;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class SongsDialog
    extends Composite<Dialog>
    implements LocaleChangeObserver {

    private final Dialog dialog = new Dialog();

    private final Paragraph p1 = new Paragraph();
    private final Paragraph p2 = new Paragraph();

    @Override
    protected Dialog initContent() {
        Image image = new Image("images/daw.png", "Ableton Live");
        image.setWidth("10rem");

        var col2 = Responsive.column(
            audio("songs/stoner-1.mp3"),
            audio("songs/stoner-2.mp3")
        )
            .alignement(Alignment.CENTER)
            .build();

        col2.getStyle().setWidth("min-content");

        var col = Responsive.column(
            p1,
            p2,
            Responsive.row(image, col2)
                .justify(JustifyContentMode.CENTER)
                .build()
        )
            .withoutSpacing()
            .build();

        dialog.add(col);
        return dialog;
    }

    public void open() {
        getContent().open();
    }

    private static Component audio(String audioUrl) {
        var audio = new Html(
            """
            <audio controls>
                <source src="%s" type="audio/mpeg">
                Your browser does not support the audio tag.
            </audio>
            """.formatted(audioUrl)
        );
        audio.addClassName("modern-audio-player");
        audio.getStyle().setWidth("40rem");

        return audio;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        dialog.setHeaderTitle(
            getTranslation("about.hobbies.listen.dialog.title")
        );

        p1.setText(getTranslation("about.hobbies.listen.dialog.p1"));
        p2.setText(getTranslation("about.hobbies.listen.dialog.p2"));
    }
}
