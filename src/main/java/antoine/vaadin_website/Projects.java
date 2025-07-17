package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Projects extends HorizontalLayout {

    public Projects() {
        setWidthFull();

        new HorizontalLayout(new Hr(), new Hr());

        var card1 = new Card();
        card1.setTitle("Portfolio");
        card1.add(
            Responsive.row(
                badge("Java : Spring Boot"),
                badge("Vaadin Flow"),
                badge("Heroku")
            ).build()
        );
        add(card1);

        var card2 = new Card();
        card2.setTitle("Jeu de rythme");
        card2.add(
            Responsive.row(
                badge("Javascript"),
                badge("Typescript"),
                badge("Github Actions")
            ).build()
        );
        add(card2);
    }

    private static Span badge(String text) {
        Span pending = new Span(text);
        pending.getElement().getThemeList().add("badge");
        return pending;
    }
}
