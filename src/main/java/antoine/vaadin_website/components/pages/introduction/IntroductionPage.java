package antoine.vaadin_website.components.pages.introduction;

import antoine.vaadin_website.components.CallbackAnchor;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class IntroductionPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");
    private final Text catchPhrase = new Text("");
    private final CallbackAnchor resumeLink = new CallbackAnchor(event -> {
        EmailServices.send(
            Args.builder()
                .subject("resume button clicked")
                .text("resume button clicked")
                .build(),
            true
        );
    }).newTab();

    @Override
    protected Page initContent() {
        var page = new Page()
            .title(title) // make the title more apparent, maybe move out of the card and center in above te cards
            .subtitle(subtitle)
            .body(catchPhrase)
            .footer(resumeLink);

        return page;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("intro.title"));
        subtitle.setText(getTranslation("intro.subtitle"));
        resumeLink.setText(getTranslation("intro.see-resume"));
        resumeLink.setHref(getTranslation("intro.link-to-resume"));
        catchPhrase.setText(getTranslation("intro.catch-phrase"));
    }
}
