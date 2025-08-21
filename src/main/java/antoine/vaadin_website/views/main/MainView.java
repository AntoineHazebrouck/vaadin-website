package antoine.vaadin_website.views.main;

import antoine.vaadin_website.Constants;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.components.Skills;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.views.ProjectsView;
import antoine.vaadin_website.views.contact.ContactView;
import antoine.vaadin_website.views.main.components.Bold;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends Page implements LocaleChangeObserver {

    Anchor resumeLink = new Anchor(Constants.Links.RESUME);
    Bold bold = new Bold();
    Text postBold = new Text("");

    public MainView() {
        bold.getStyle().setFontSize("1.5em");

        var text = new Paragraph();
        text.add(bold);
        text.add(postBold);

        resumeLink.setTarget("_tab");
        resumeLink.getStyle().setMargin("auto");
        resumeLink.getElement().getThemeList().add("link-to-resume");

        var image = new Image(
            "/images/IMG_20250717_210710.webp",
            "Antoine HAZEBROUCK"
        );
        image.getElement().getThemeList().add("portrait");

        add(
            Responsive.row(
                new VerticalLayout(
                    new H1("Antoine HAZEBROUCK"),
                    text,
                    resumeLink
                ),
                image
            )
                .justify(JustifyContentMode.AROUND)
                .build()
        );

        add(new Skills());
    }

    @Override
    public Class<? extends Component> previous() {
        return ProjectsView.class;
    }

    @Override
    public Class<? extends Component> next() {
        return ContactView.class;
    }

    @Override
    public String getPageTitle() {
        return getTranslation("main.page-title");
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        resumeLink.setText(getTranslation("main.see-resume"));
        bold.setText(getTranslation("main.bold-text"));
        postBold.setText(" " + getTranslation("main.post-text"));
    }
}
