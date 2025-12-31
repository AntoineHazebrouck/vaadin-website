package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.components.CallbackAnchor;
import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class PersonalInformation
    extends Composite<AccordionPanel>
    implements LayoutMixin, LocaleChangeObserver {

    private final Span title = new Span("");
    private final Span phone = new Span("");
    private final Span email = new Span("");
    private final Span city = new Span("");
    private final Span drivingLicense = new Span("");

    @Override
    protected AccordionPanel initContent() {
        var linkedin = new CallbackAnchor(event -> {
            EmailServices.send(
                Args.builder()
                    .subject("linkedin button clicked")
                    .text("linkedin button clicked")
                    .build(),
                true
            );
        })
            .newTab()
            .setHref("https://www.linkedin.com/in/antoine-hazebrouck-775533261")
            .setText("LinkedIn");

        return new AccordionPanel(
            title,
            Responsive.column(phone, email, linkedin, city, drivingLicense)
                .withoutSpacing()
                .build()
        );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("about.personal-information.title"));
        phone.setText(getTranslation("about.personal-information.phone"));
        email.setText(getTranslation("about.personal-information.email"));
        city.setText(getTranslation("about.personal-information.city"));
        drivingLicense.setText(
            getTranslation("about.personal-information.driving-license")
        );
    }
}
