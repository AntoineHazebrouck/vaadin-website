package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;

public class Projects extends VerticalLayout {

    public Projects() {
        setWidthFull();
        setAlignItems(Alignment.CENTER);

        add(new H3("Mes projets"));

        var card1 = ExperienceCard.builder()
            .title("Portfolio")
            .headerSuffix(
                sourceCodeLink(
                    "https://github.com/AntoineHazebrouck/vaadin-website"
                )
            )
            .content(
                List.of(
                    Responsive.row(
                        badge("Java : Spring Boot"),
                        badge("Vaadin Flow"),
                        badge("Heroku")
                    ).build()
                )
            )
            .build()
            .toCard();

        var card2 = new Card();
        card2.setTitle("Jeu de rythme");
        card2.add(
            Responsive.row(
                badge("Javascript"),
                badge("Typescript"),
                badge("Github Actions")
            ).build()
        );

        var card3 = new Card();
        card3.setTitle("Alerting par email");
        card3.add(
            Responsive.row(
                badge("Gmail"),
                badge("Java : Spring Boot"),
                badge("Github Actions"),
                badge("Scala")
            ).build()
        );
        add(Responsive.row(card1, card2, card3).build());
    }

    private static Span badge(String text) {
        Span pending = new Span(text);
        pending.getElement().getThemeList().add("badge");
        return pending;
    }

    private static Anchor sourceCodeLink(String to) {
        var link = new Anchor(to, "code source");
        link.setTarget("_tab");
        return link;
    }
}
