package antoine.vaadin_website.views.experiences;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.components.pages.experiences.ButInformatiqueCard;
import antoine.vaadin_website.components.pages.experiences.IngenieurInformatiqueCard;
import antoine.vaadin_website.components.pages.experiences.SocgenCard;
import antoine.vaadin_website.utils.Responsive;

@Route("experiences")
public class ExperiencesView extends Page implements LocaleChangeObserver {

    public static final String WIDTH = "100%";

    H3 academicTitle = new H3();
    H3 professionalTitle = new H3();

    public ExperiencesView() {
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
