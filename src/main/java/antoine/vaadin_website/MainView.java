package antoine.vaadin_website;

import antoine.vaadin_website.components.CopyrightFooter;
import antoine.vaadin_website.components.pages.aboutme.AboutMePage;
import antoine.vaadin_website.components.pages.contactme.ContactMePage;
import antoine.vaadin_website.components.pages.experiences.ExperiencesPage;
import antoine.vaadin_website.components.pages.introduction.IntroductionPage;
import antoine.vaadin_website.components.pages.projects.ProjectsPage;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route
@PageTitle("Antoine HAZEBROUCK")
public class MainView extends Composite<VerticalLayout> {

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
        var row1 = Responsive.row(
            Responsive.column(new IntroductionPage()).padding("0").build(),
            Responsive.column(new AboutMePage()).padding("0").build()
        )
            .alignement(Alignment.CENTER)
            .build();

        row1.getStyle().setMinHeight("100vh");

        VerticalLayout desktop = (VerticalLayout) Responsive.column(
            row1,
            new ContactMePage(),
            new ExperiencesPage(),
            new ProjectsPage(),
            new CopyrightFooter()
        ).build();
        return desktop;
    }
}
