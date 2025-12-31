package antoine.vaadin_website.config;

import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.SessionInitEvent;
import com.vaadin.flow.server.UIInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import java.util.ArrayList;
import java.util.Locale;
import org.springframework.context.annotation.Configuration;

@Configuration
@Theme("my-theme")
public class WebsiteConfig
    implements AppShellConfigurator, VaadinServiceInitListener {

    @Override
    public void configurePage(AppShellSettings settings) {
        settings.addFavIcon("icon", "icons/ah.ico", "192x192");
    }

    @Override
    public void serviceInit(ServiceInitEvent event) {
        var source = event.getSource();

        source.addSessionInitListener(sessionInit -> {
            sendNewSessionUserTracking(sessionInit);
        });

        source.addUIInitListener(uiInit -> {
            defaultUiLocaleToEnglish(uiInit);
            openDialogIfBrowserIsFrench(uiInit);
        });
    }

    private static void sendNewSessionUserTracking(
        SessionInitEvent sessionInit
    ) {
        var clientIp = sessionInit.getRequest().getRemoteAddr();
        var clientLocales = new ArrayList<Locale>();
        sessionInit
            .getRequest()
            .getLocales()
            .asIterator()
            .forEachRemaining(locale -> clientLocales.add(locale));

        var referer = sessionInit.getRequest().getHeader("Referer");

        EmailServices.send(
            Args.builder()
                .subject("website visited")
                .text(
                    """
                    referer=%s
                    clientLocales=%s
                    clientIp=%s
                    """.formatted(referer, clientIp, clientLocales)
                )
                .build(),
            true
        );
    }

    private static void defaultUiLocaleToEnglish(UIInitEvent uiInit) {
        uiInit.getUI().setLocale(Locale.ENGLISH);
    }

    private static void openDialogIfBrowserIsFrench(UIInitEvent uiInit) {
        String browserLanguage = VaadinSession.getCurrent()
            .getBrowser()
            .getLocale()
            .getLanguage();

        var userIsFrench = Locale.FRENCH.getLanguage().equals(browserLanguage);

        if (userIsFrench) {
            var dialog = new Dialog("French ?");

            var toFrench = new Button("Switch to French", buttonEvent -> {
                UI.getCurrent().setLocale(Locale.FRENCH);
                dialog.close();
            });
            var toEnglish = new Button("Stay in English", buttonEvent -> {
                dialog.close();
            });
            toEnglish.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
            dialog.add(Responsive.row(toFrench, toEnglish).wrap().build());
            dialog.open();
        }
    }
}
