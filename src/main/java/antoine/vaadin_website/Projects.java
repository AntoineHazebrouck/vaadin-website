package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;

public class Projects extends VerticalLayout {

    private static final String WIDTH = "33%";

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
            .minWidth(WIDTH)
            .build()
            .toCard();

        var card2 = ExperienceCard.builder()
            .title("Jeu de rythme")
            .headerSuffix(
                sourceCodeLink("https://github.com/AntoineHazebrouck/rythm")
            )
            .content(
                List.of(
                    new Paragraph(
                        new Text("Une version web de "),
                        new Anchor(
                            "https://osu.ppy.sh/wiki/en/Game_mode/osu%21mania",
                            "osu!mania"
                        ),
                        new Text(
                            " permettant d'y importer les musiques originales du jeu."
                        )
                    ),
                    Responsive.row(
                        badge("Java : Spring Boot"),
                        badge("Thymeleaf"),
                        badge("Javascript")
                    ).build(),
                    Responsive.row(
                        badge("Typescript"),
                        badge("Github Actions"),
                        badge("Infra/DevOps")
                    ).build(),
                    Responsive.row(badge("H2")).build()
                )
            )
            .minWidth(WIDTH)
            .build()
            .toCard();

        var card3 = ExperienceCard.builder()
            .title("Alerting par email")
            .headerSuffix(sourceCodeLink("TODO"))
            .content(
                List.of(
                    new Paragraph(
                        "Me permet de recevoir des notifications pour des sujets variés : "
                    ),
                    new UnorderedList(
                        new ListItem("idées de recettes"),
                        new ListItem("loyer"),
                        new ListItem("anniversaires")
                    ),
                    Responsive.row(
                        badge("Gmail"),
                        badge("Java : Spring Boot"),
                        badge("Github Actions")
                    ).build(),
                    Responsive.row(
                        badge("Github Actions"),
                        badge("Scala")
                    ).build()
                )
            )
            .minWidth(WIDTH)
            .build()
            .toCard();

        add(Responsive.row(card1, card2, card3).build());
    }

    private static Span badge(String text) {
        Span pending = new Span(text);
        pending.getElement().getThemeList().add("badge");
        pending.getStyle().setMargin("4px");
        return pending;
    }

    private static Anchor sourceCodeLink(String to) {
        var link = new Anchor(to, "code source");
        link.setTarget("_tab");
        return link;
    }
}
