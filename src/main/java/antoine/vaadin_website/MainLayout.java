package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.ProjectsView;
import antoine.vaadin_website.views.contact.ContactView;
import antoine.vaadin_website.views.experiences.ExperiencesView;
import antoine.vaadin_website.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.IconFactory;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.Locale;

@Layout
public class MainLayout
    extends AppLayout
    implements AfterNavigationObserver, LocaleChangeObserver {

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
    private Button toFrench = new Button("FR", event -> {
        UI.getCurrent().setLocale(Locale.FRENCH);
        UI.getCurrent().navigate(UI.getCurrent().getCurrentView().getClass());
    });
    private Button toEnglish = new Button("EN", event -> {
        UI.getCurrent().setLocale(Locale.ENGLISH);
        UI.getCurrent().navigate(UI.getCurrent().getCurrentView().getClass());
    });

    public MainLayout() {
        H1 title = new H1("AH");
        title
            .getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .setMarginLeft("4em")
            .setMarginRight("auto");

        var nav = (HorizontalLayout) Responsive.row(tabs)
            .justify(JustifyContentMode.CENTER)
            .wrap()
            .build();

        nav.getStyle().setMarginTop("auto");

        nav.getStyle().setMarginLeft("auto").setMarginRight("auto");

        addToNavbar(title);
        addToNavbar(true, nav);

        toFrench.addThemeName("to-french-toggle");
        toEnglish.addThemeName("to-english-toggle");
        toEnglish.addClassNames(LumoUtility.Margin.End.SMALL);

        addToNavbar(toFrench, toEnglish);
    }

    private Tab navbarLink(
        String text,
        IconFactory icon,
        Class<? extends Component> target
    ) {
        var touchscreen = icon.create();
        touchscreen
            .getElement()
            .getThemeList()
            .add(Constants.Themes.TOUCHSCREEN_ONLY);
        touchscreen.setSize("2em");

        var desktop = new Paragraph(text);
        desktop.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
        desktop.getStyle().setMargin("0");

        RouterLink routerLink = new RouterLink(target);
        routerLink.add(touchscreen);
        routerLink.add(desktop);
        return new Tab(routerLink);
    }

    private Tabs tabs() {
        var tabs2 = new Tabs(home, contact, experiences, projects);
        tabs2.setAutoselect(false);
        tabs2.getThemeNames().add("navbar-tabs");
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

    @Override
    public void localeChange(LocaleChangeEvent event) {
        switch (event.getLocale()) {
            case Locale locale when locale.equals(Locale.FRENCH) -> {
                toFrench.setEnabled(false);
                toEnglish.setEnabled(true);
                Notification.show("Français activé");
            }
            case Locale locale when locale.equals(Locale.ENGLISH) -> {
                toFrench.setEnabled(true);
                toEnglish.setEnabled(false);
                Notification.show("English activated");
            }
            default -> {
                Notification.show(
                    "Error changing the language, or your language is not available. Defaulting to english."
                );
                UI.getCurrent().setLocale(Locale.ENGLISH);
            }
        }
    }
}
