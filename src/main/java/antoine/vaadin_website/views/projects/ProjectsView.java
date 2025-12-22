package antoine.vaadin_website.views.projects;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.components.pages.projects.AdsSocialNetwork;
import antoine.vaadin_website.components.pages.projects.DataClassifier;
import antoine.vaadin_website.components.pages.projects.EmailAlerts;
import antoine.vaadin_website.components.pages.projects.Rythm;
import antoine.vaadin_website.components.pages.projects.VaadinWebsite;
import antoine.vaadin_website.utils.Responsive;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("projects")
public class ProjectsView extends Page implements LocaleChangeObserver {

    H1 title = new H1();

    public ProjectsView() {
        // Component card1 = new VaadinWebsite();
        // Component card2 = new Rythm();
        // Component card3 = new EmailAlerts();
        // Component card4 = new DataClassifier();
        // Component card5 = new AdsSocialNetwork();

        // card1.addClassNames(LumoUtility.Flex.ONE);
        // card2.addClassNames(LumoUtility.Flex.ONE);
        // card3.addClassNames(LumoUtility.Flex.ONE);
        // card4.addClassNames(LumoUtility.Flex.ONE);
        // card5.addClassNames(LumoUtility.Flex.ONE);

        // add(title);
        // add(Responsive.row(card1, card2).build());
        // add(Responsive.row(card3, card4).build());
        // add(Responsive.row(card5).build());
    }

    // @Override
    // public Class<? extends Component> previous() {
    //     return ExperiencesView.class;
    // }

    // @Override
    // public Class<? extends Component> next() {
    //     return MainView.class;
    // }

    // @Override
    // public String getPageTitle() {
    //     return getTranslation("projects.page-title");
    // }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.title"));
    }
}
