package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.HasText.WhiteSpace;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Information extends VerticalLayout {

    public Information() {
        add(new H3("Informations"));

        var col = Responsive.column(
            Responsive.row(label("Ville : "), new Span("59000, Lille"))
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

        add(col);

        var col2 = Responsive.column(
            Responsive.row(new H3("Loisirs"), new H3(""))
                .justify(JustifyContentMode.AROUND)
                .build(),
            Responsive.row(
                label("Musique : "),
                new Span("guitare, basse, composition")
            )
                .alignement(Alignment.CENTER)
                .wrap()
                .build(),
            Responsive.row(label("Dessin"), new H3(""))
                .alignement(Alignment.CENTER)
                .justify(JustifyContentMode.AROUND)
                .wrap()
                .build(),
            Responsive.row(
                label("Jeux video : "),
                new Span("équipe, competitifs, fps")
            )
                .alignement(Alignment.CENTER)
                .wrap()
                .build()
        ).build();

        add(col2);
    }

    private static H5 label(String text) {
        var label = new H5(text);
        label.setWhiteSpace(WhiteSpace.NOWRAP);
        return label;
    }
}
