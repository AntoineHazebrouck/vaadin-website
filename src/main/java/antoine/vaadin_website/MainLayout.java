package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.ContactView;
import antoine.vaadin_website.views.ExperiencesView;
import antoine.vaadin_website.views.MainView;
import antoine.vaadin_website.views.ProjectsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;

@Layout
public class MainLayout extends AppLayout {

    public static final String appBarOffset = "4em";

    public MainLayout() {
        H1 title = new H1("AH");
        title
            .getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .setMargin("5px");

        var linkToResume = new Anchor(
            "/ANTOINE_HAZEBROUCK_CV.pdf",
            new Text("CV")
        );
        linkToResume.setTarget("_tab");
        linkToResume.getElement().getThemeList().add("navbar-link");

        var spacer1 = new Div();
        var spacer2 = new Div();
        var spacer3 = new Div();

        var nav = (HorizontalLayout) Responsive.row(
            spacer1,
            title,
            spacer2,
            navbarLink("Accueil", MainView.class),
            navbarLink("Contact", ContactView.class),
            navbarLink("Parcours", ExperiencesView.class),
            navbarLink("Projets", ProjectsView.class),
            linkToResume,
            spacer3
        )
            .alignement(Alignment.CENTER)
            .build();

        nav.setFlexGrow(1, spacer1);
        nav.setFlexGrow(1, spacer2);
        nav.setFlexGrow(3, spacer3);

        addToNavbar(nav);
    }

    private Component navbarLink(
        String text,
        Class<? extends Component> target
    ) {
        RouterLink routerLink = new RouterLink(text, target);
        routerLink.getElement().getThemeList().add("navbar-link");
        return routerLink;
    }
}
