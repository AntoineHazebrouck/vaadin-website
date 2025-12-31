package antoine.vaadin_website;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.Locale;

@Layout
// @PreserveOnRefresh // "french switch dialogs" remains after refresh
public class MainLayout extends AppLayout implements LocaleChangeObserver {

    Button toFrench = new Button("FR", event -> {
        UI.getCurrent().setLocale(Locale.FRENCH);
        UI.getCurrent().navigate(UI.getCurrent().getCurrentView().getClass());
    });
    Button toEnglish = new Button("EN", event -> {
        UI.getCurrent().setLocale(Locale.ENGLISH);
        UI.getCurrent().navigate(UI.getCurrent().getCurrentView().getClass());
    });

    public MainLayout() {
        var desktopTitle = new H1("Antoine HAZEBROUCK");
        desktopTitle.addClassName("only-on-desktop");
        desktopTitle
            .getStyle()
            .set("font-size", "var(--lumo-font-size-xl)")
            .setMarginLeft("4em")
            .setMarginRight("auto");

        var touchscreenTitle = new H1("Antoine HAZEBROUCK");
        touchscreenTitle.addClassName("only-on-touchscreen");
        touchscreenTitle
            .getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .setMarginLeft("1em")
            .setMarginRight("auto");

        addToNavbar(desktopTitle, touchscreenTitle);

        toFrench.addClassName("to-french-toggle");
        toEnglish.addClassName("to-english-toggle");
        toEnglish.addClassNames(LumoUtility.Margin.End.SMALL);

        addToNavbar(toFrench, toEnglish);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        switch (event.getLocale().getLanguage()) {
            case "fr" -> {
                toFrench.setEnabled(false);
                toEnglish.setEnabled(true);
                Notification.show("Français activé");
            }
            case "en" -> {
                toFrench.setEnabled(true);
                toEnglish.setEnabled(false);
                Notification.show("English activated");
            }
        }
    }
}
