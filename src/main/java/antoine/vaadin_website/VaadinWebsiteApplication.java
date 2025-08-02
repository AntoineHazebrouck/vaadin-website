package antoine.vaadin_website;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme("my-theme")
public class VaadinWebsiteApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(VaadinWebsiteApplication.class, args);
    }

    @Override
    public void configurePage(AppShellSettings settings) {
        settings.addFavIcon("icon", "icons/ah.ico", "192x192");
    }
}
