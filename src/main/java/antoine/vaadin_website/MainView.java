package antoine.vaadin_website;

import antoine.vaadin_website.components.Bold;
import antoine.vaadin_website.components.CopyrightFooter;
import antoine.vaadin_website.components.pages.aboutme.AboutMePage;
import antoine.vaadin_website.components.pages.contactme.ContactMePage;
import antoine.vaadin_website.components.pages.experiences.ExperiencesPage;
import antoine.vaadin_website.components.pages.introduction.IntroductionPage;
import antoine.vaadin_website.components.pages.projects.ProjectsPage;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
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

    @Override
    protected VerticalLayout initContent() {
        VerticalLayout desktop = application();
        desktop.addClassNames(
            LumoUtility.Gap.Row.MEDIUM,
            LumoUtility.Gap.Column.MEDIUM,
            LumoUtility.Padding.Top.MEDIUM,
            LumoUtility.Padding.Right.XLARGE,
            LumoUtility.Padding.Bottom.MEDIUM,
            LumoUtility.Padding.Left.XLARGE
        );
        desktop.addClassName("only-on-desktop");

        VerticalLayout touchscreen = application();
        touchscreen.addClassName("only-on-touchscreen");

        return (VerticalLayout) Responsive.column(desktop, touchscreen)
            .padding("0")
            .build();
    }

    private VerticalLayout application() {
        VerticalLayout desktop = (VerticalLayout) Responsive.column(
            Responsive.row(
                Responsive.column(new IntroductionPage()).padding("0").build(),
                Responsive.column(new AboutMePage()).padding("0").build()
            ).build(),
            new ContactMePage(),
            new ExperiencesPage(),
            new ProjectsPage(),
            new CopyrightFooter()
        ).build();
        return desktop;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        preBold.setText(getTranslation("main.pre-text"));
        bold.setText(getTranslation("main.bold-text"));
        postBold.setText(" " + getTranslation("main.post-text"));
    }
}
