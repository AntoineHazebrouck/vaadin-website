package antoine.vaadin_website.config;

import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
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
        event
            .getSource()
            .addSessionInitListener(sessionEvent -> {
                var clientIp = sessionEvent.getRequest().getRemoteAddr();
                var clientLocales = new ArrayList<Locale>();
                sessionEvent
                    .getRequest()
                    .getLocales()
                    .asIterator()
                    .forEachRemaining(locale -> clientLocales.add(locale));

                EmailServices.send(
                    Args.builder()
                        .subject("website visited")
                        .text(
                            """
                            clientIp=%s
                            clientLocales=%s
                            """.formatted(clientIp, clientLocales)
                        )
                        .build(),
                    true
                );
            });
    }
}
