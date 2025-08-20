package antoine.vaadin_website.views;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.Route;
import java.util.List;

@Route("experiences")
public class ExperiencesView extends Page {

    private static final String WIDTH = "100%";

    public ExperiencesView() {
        var education = Responsive.column(
            new H3("Parcours scolaire"),
            CustomCard.builder()
                .width(WIDTH)
                .minHeight("15em")
                .title("BUT Informatique")
                .subtitle("IUT de Lille")
                .content(
                    List.of(
                        new Paragraph(
                            "J'y ai appris toutes les bases de la réalisation d'applications : "
                        ),
                        new UnorderedList(
                            new ListItem(
                                "conception : UI/UX, design, recueil des besoins, prototypage"
                            ),
                            new ListItem(
                                "développement : web, mobile, desktop"
                            ),
                            new ListItem(
                                "validation : tests automatisés, go du client"
                            ),
                            new ListItem("déploiement : mise en production"),
                            new ListItem(
                                "gestion de projet : agilité, accompagnement client"
                            )
                        )
                    )
                )
                .headerSuffix(new Text("2021-2024"))
                .build(),
            CustomCard.builder()
                .width(WIDTH)
                .minHeight("15em")
                .title("Ingénieur informatique (CTI)")
                .subtitle("IMT Nord Europe - Lille")
                .content(List.of())
                .headerSuffix(new Text("2024-2027"))
                .build()
        )
            .alignement(Alignment.CENTER)
            .build();

        var professional = Responsive.column(
            new H3("Parcours professionnel"),
            CustomCard.builder()
                .width(WIDTH)
                .minHeight("22.5em")
                .title("Apprenti ingénieur logiciel")
                .subtitle("Société Générale - La Défense")
                .content(
                    List.of(
                        new Paragraph(
                            "Dans un contexte international, j'ai créé, amélioré et maintenu une large chaîne d'outils répondant aux risques structurels et aux besoins de pilotage du groupe vis-à-vis de la direction financière. "
                        ),
                        new Paragraph(
                            "J'ai notamment, au sein de l'équipe data quality, implementé la consolidation, la coherence et la validation qualitative du bilan du groupe. "
                        ),
                        new Paragraph(
                            "J'ai aussi eu l'occasion de mener dans sa totalité un projet de calibration du bilan interne sur un socle agile, priorisant la satisfaction client. "
                        )
                    )
                )
                .headerSuffix(new Text("2023-2027"))
                .build()
        )
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.BETWEEN)
            .build();

        addContent(Responsive.row(education, professional).build());
    }

    @Override
    public Class<? extends Component> previous() {
        return ContactView.class;
    }

    @Override
    public Class<? extends Component> next() {
        return ProjectsView.class;
    }

    @Override
    public String getPageTitle() {
        return getTranslation("experiences.page-title");
    }
}
