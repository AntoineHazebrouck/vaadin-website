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
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.IconFactory;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;

@Layout
public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 title = new H1("AH");
        title
            .getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .setMarginLeft("4em")
            .setMarginRight("auto");

        var linkToResume = new Anchor(Constants.Links.RESUME, new Text("CV"));
        linkToResume.setTarget("_tab");
        linkToResume.getElement().getThemeList().add("navbar-link");

        var nav = (HorizontalLayout) Responsive.row(
            navbarLink("Accueil", VaadinIcon.HOME_O, MainView.class),
            navbarLink("Contact", VaadinIcon.CHAT, ContactView.class),
            navbarLink(
                "Parcours",
                VaadinIcon.ACADEMY_CAP,
                ExperiencesView.class
            ),
            navbarLink("Projets", VaadinIcon.CODE, ProjectsView.class),
            linkToResume
        )
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.CENTER)
            .wrap()
            .build();

        nav.getStyle().setMarginLeft("auto").setMarginRight("auto");

        addToNavbar(title);
        addToNavbar(true, nav);
    }

    private Component navbarLink(
        String text,
        IconFactory icon,
        Class<? extends Component> target
    ) {
        var touchscreen = icon.create();
        touchscreen.getElement().getThemeList().add("only-on-touchscreen");

        var desktop = new Paragraph(text);
        desktop.getElement().getThemeList().add("only-on-desktop");
        desktop.getStyle().setMargin("0");

        RouterLink routerLink = new RouterLink(target);
        routerLink.getElement().getThemeList().add("navbar-link");
        routerLink.add(touchscreen);
        routerLink.add(desktop);
        return routerLink;
    }
}
