package antoine.vaadin_website.views.experiences;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.experiences.components.cards.ButInformatiqueCard;
import antoine.vaadin_website.views.experiences.components.cards.IngenieurInformatiqueCard;
import antoine.vaadin_website.views.experiences.components.cards.SocgenCard;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;

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
            new SocgenCard()
        )
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.BETWEEN)
            .build();
        // add(Responsive.row(education, professional).build());
    }

    // @Override
    // public Class<? extends Component> previous() {
    //     return ContactView.class;
    // }

    // @Override
    // public Class<? extends Component> next() {
    //     return ProjectsView.class;
    // }

    // @Override
    // public String getPageTitle() {
    //     return getTranslation("experiences.page-title");
    // }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        academicTitle.setText(getTranslation("experiences.title.academic"));
        professionalTitle.setText(
            getTranslation("experiences.title.professional")
        );
    }
}
