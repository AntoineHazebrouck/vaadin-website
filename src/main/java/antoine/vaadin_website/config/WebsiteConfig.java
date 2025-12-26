package antoine.vaadin_website.config;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.theme.Theme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        var emails = Ioc.getBean(JavaMailSender.class);

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

                SimpleMailMessage mailToMe = new SimpleMailMessage();
                mailToMe.setTo("antoine.haz@gmail.com");
                mailToMe.setFrom("antoine.haz@gmail.com");
                mailToMe.setSubject("Website visited");
                mailToMe.setText(
                    """
                    clientIp=%s
                    clientLocales=%s
                    """.formatted(clientIp, clientLocales)
                );

                emails.send(mailToMe);

                log.info("Email sent to antoine.haz@gmail.com : {}", mailToMe);
            });
    }
}
