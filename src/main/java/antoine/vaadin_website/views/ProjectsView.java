package antoine.vaadin_website.views;

import antoine.vaadin_website.ExperienceCard;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;
import java.util.stream.Stream;

@Route("projets")
@PageTitle("Projects")
public class ProjectsView extends VerticalLayout {

    private static final String WIDTH = "33%";

    public ProjectsView() {
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
                List.of(badges("Java : Spring Boot", "Vaadin Flow", "Heroku"))
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
                    badges(
                        "Java : Spring Boot",
                        "Thymeleaf",
                        "Javascript",
                        "Typescript",
                        "Github Actions",
                        "Infra/DevOps",
                        "H2"
                    )
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
                    badges(
                        "Gmail",
                        "Java : Spring Boot",
                        "Scala",
                        "Github Actions"
                    )
                )
            )
            .minWidth(WIDTH)
            .build()
            .toCard();

        var card4 = ExperienceCard.builder()
            .title("Explorateur de données")
            .headerSuffix(sourceCodeLink("TODO"))
            .content(
                List.of(
                    new Paragraph(
                        "Application desktop permettant d'explorer un jeu de données visuellement (via deux caractéristiques), et d'y appliquer des algorithmes d'apprentissages."
                    ),
                    badges("Java", "JavaFX", "Junit")
                )
            )
            .minWidth(WIDTH)
            .build()
            .toCard();

        var card5 = ExperienceCard.builder()
            .title("Réseau social de petites annonces")
            .headerSuffix(sourceCodeLink("TODO"))
            .content(
                List.of(
                    new Paragraph(
                        "Réseau web/mobile exclusif permettant aux utilisateurs de poster/consulter des annonces en tout genres (babysitting, jardinage, ...)."
                    ),
                    new Paragraph(
                        "Travail en équipe de 8 sur une semaine en agilité face au client."
                    ),
                    badges(
                        "Java : Spring Boot",
                        "REST API",
                        "Postgres",
                        "Agilité"
                    )
                )
            )
            .minWidth(WIDTH)
            .build()
            .toCard();

        add(Responsive.row(card1, card2, card3).build());
        add(Responsive.row(card4, card5, card5).build());
    }

    private static Component badges(String... labels) {
        return Responsive.row(
            Stream.of(labels).map(ProjectsView::badge).toArray(Component[]::new)
        )
            .justify(JustifyContentMode.EVENLY)
            .wrap()
            .build();
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
