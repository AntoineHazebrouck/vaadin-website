package antoine.vaadin_website.views.experiences;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.ContactView;
import antoine.vaadin_website.views.ProjectsView;
import antoine.vaadin_website.views.experiences.components.cards.ButInformatiqueCard;
import antoine.vaadin_website.views.experiences.components.cards.IngenieurInformatiqueCard;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import java.util.List;

@Route("experiences")
public class ExperiencesView extends Page implements LocaleChangeObserver {

    public static final String WIDTH = "100%";

    H3 academicTitle = new H3();
    H3 professionalTitle = new H3();

    public ExperiencesView() {
        var education = Responsive.column(
            academicTitle,
            new ButInformatiqueCard(),
            new IngenieurInformatiqueCard()
        )
            .alignement(Alignment.CENTER)
            .build();

        var professional = Responsive.column(
            professionalTitle,
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

    @Override
    public void localeChange(LocaleChangeEvent event) {
        academicTitle.setText(getTranslation("experiences.title.academic"));
        professionalTitle.setText(
            getTranslation("experiences.title.professional")
        );
    }
}
