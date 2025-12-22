package antoine.vaadin_website.views.main;

import antoine.vaadin_website.components.CopyrightFooter;
import antoine.vaadin_website.components.pages.aboutme.AboutMePage;
import antoine.vaadin_website.components.pages.contactme.ContactMePage;
import antoine.vaadin_website.components.pages.experiences.ExperiencesPage;
import antoine.vaadin_website.components.pages.introduction.IntroductionPage;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.main.components.Bold;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route
public class MainView
    extends Composite<VerticalLayout>
    implements LocaleChangeObserver {

    Text preBold = new Text("");
    Bold bold = new Bold();
    Text postBold = new Text("");

    public MainView() {
        getContent()
            .add(
                Responsive.row(
                    Responsive.column(new IntroductionPage())
                        .padding("0")
                        .build(),
                    Responsive.column(new AboutMePage()).padding("0").build()
                ).build()
            );
        getContent().add(new ContactMePage()); // TODO make small variations in the colors
        getContent().add(new ExperiencesPage());
        getContent().add(projects());
        getContent().add(new CopyrightFooter());

        addClassNames(
            LumoUtility.Gap.Row.MEDIUM,
            LumoUtility.Gap.Column.MEDIUM,
            LumoUtility.Padding.Top.MEDIUM,
            LumoUtility.Padding.Right.XLARGE,
            LumoUtility.Padding.Bottom.MEDIUM,
            LumoUtility.Padding.Left.XLARGE
        );
    }

    private Card projects() {
        Card card = new Card();
        card.setTitle("My projects");

        card.add("contact form + email as info");
        card.setThemeName("outlined");
        card.getStyle().set("width", "100%");

        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        preBold.setText(getTranslation("main.pre-text"));
        bold.setText(getTranslation("main.bold-text"));
        postBold.setText(" " + getTranslation("main.post-text"));
    }
}
