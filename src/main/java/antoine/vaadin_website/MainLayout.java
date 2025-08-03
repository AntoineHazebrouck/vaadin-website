package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.ContactView;
import antoine.vaadin_website.views.ExperiencesView;
import antoine.vaadin_website.views.MainView;
import antoine.vaadin_website.views.ProjectsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.IconFactory;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;

@Layout
public class MainLayout extends AppLayout implements AfterNavigationObserver {

    private Tab home = navbarLink("Accueil", VaadinIcon.HOME_O, MainView.class);
    private Tab contact = navbarLink(
        "Contact",
        VaadinIcon.CHAT,
        ContactView.class
    );
    private Tab experiences = navbarLink(
        "Parcours",
        VaadinIcon.ACADEMY_CAP,
        ExperiencesView.class
    );
    private Tab projects = navbarLink(
        "Projets",
        VaadinIcon.CODE,
        ProjectsView.class
    );
    private Tabs tabs = tabs();

    public MainLayout() {
        H1 title = new H1("AH");
        title
            .getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .setMarginLeft("4em")
            .setMarginRight("auto");

        var nav = (HorizontalLayout) Responsive.row(tabs)
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.CENTER)
            .wrap()
            .build();

        nav.getStyle().setMarginLeft("auto").setMarginRight("auto");

        addToNavbar(title);
        addToNavbar(true, nav);
    }

    private Tab navbarLink(
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
        routerLink.add(touchscreen);
        routerLink.add(desktop);
        return new Tab(routerLink);
    }

    private Tabs tabs() {
        var tabs2 = new Tabs(home, contact, experiences, projects);
        tabs2.setAutoselect(false);
        return tabs2;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        Tab currentTab =
            switch (UI.getCurrent().getCurrentView()) {
                case MainView pass -> home;
                case ContactView pass -> contact;
                case ExperiencesView pass -> experiences;
                case ProjectsView pass -> projects;
                default -> {
                    UI.getCurrent().navigate(MainView.class);
                    yield home;
                }
            };
        tabs.setSelectedTab(currentTab);
    }
}
