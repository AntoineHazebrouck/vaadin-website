package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.components.EmailTrackingAnchor;
import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.H5;
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
        var linkedin = new EmailTrackingAnchor("linkedin button clicked")
            .newTab()
            .setHref("https://www.linkedin.com/in/antoinehazebrouck")
            .setText("LinkedIn");

        var github = new EmailTrackingAnchor("github button clicked")
            .newTab()
            .setHref("https://github.com/AntoineHazebrouck")
            .setText("Github");

        return new AccordionPanel(
            new H5(title),
            Responsive.column(
                phone,
                email,
                linkedin,
                github,
                city,
                drivingLicense
            )
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
