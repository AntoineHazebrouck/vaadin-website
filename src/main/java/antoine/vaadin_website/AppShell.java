package antoine.vaadin_website;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;

public class AppShell implements AppShellConfigurator {

    @Override
    public void configurePage(AppShellSettings settings) {
        settings.setViewport("width=device-width, initial-scale=1");
        settings.setPageTitle("Antoine Hazebrouck");
        settings.setBodySize("100vw", "100vh");
        // settings.addMetaTag("author", "bunny");
        settings.addFavIcon("icon", "icons/ah.ico", "192x192");
        // settings.addLink("shortcut icon", "icons/favicon.ico");
    }
}
