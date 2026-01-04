package antoine.vaadin_website.components.pages.introduction;

import antoine.vaadin_website.components.EmailTrackingAnchor;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class IntroductionPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");
    private final Text catchPhrase = new Text("");

    private final Button resumeLinkText = button(
        "",
        ButtonVariant.LUMO_LARGE,
        ButtonVariant.LUMO_PRIMARY
    );
    private final EmailTrackingAnchor resumeLink = new EmailTrackingAnchor(
        "resume button clicked"
    )
        .newTab()
        .add(resumeLinkText);

    @Override
    protected Page initContent() {
        var linkedInLink = new EmailTrackingAnchor(
            "linkedin button clicked from introduction"
        )
            .newTab()
            .setHref("https://www.linkedin.com/in/antoinehazebrouck/")
            .add(button("LinkedIn", ButtonVariant.LUMO_LARGE));

        var githubLink = new EmailTrackingAnchor(
            "github button clicked from introduction"
        )
            .newTab()
            .setHref("https://github.com/AntoineHazebrouck")
            .add(
                button(
                    "Github",
                    ButtonVariant.LUMO_LARGE,
                    ButtonVariant.LUMO_TERTIARY
                )
            );

        var page = new Page()
            .bigTitle(title)
            .bigSubtitle(subtitle)
            .body(catchPhrase)
            .footer(
                Responsive.row(resumeLink, linkedInLink, githubLink)
                    .wrap()
                    .build()
            );

        return page;
    }

    private Button button(String text, ButtonVariant... variants) {
        var button = new Button(text);
        button.addThemeVariants(variants);
        return button;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("intro.title"));
        subtitle.setText(getTranslation("intro.subtitle"));
        resumeLinkText.setText(getTranslation("intro.see-resume"));
        resumeLink.setHref(getTranslation("intro.link-to-resume"));
        catchPhrase.setText(getTranslation("intro.catch-phrase"));
    }
}
