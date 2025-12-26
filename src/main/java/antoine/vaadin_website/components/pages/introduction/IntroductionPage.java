package antoine.vaadin_website.components.pages.introduction;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class IntroductionPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");
    private final Anchor resumeLink = new Anchor(); // TODO email when clicked
    private final Text catchPhrase = new Text("");

    @Override
    protected Page initContent() {
        resumeLink.setTarget("_tab");
        resumeLink.addClassName("link-to-resume");

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
