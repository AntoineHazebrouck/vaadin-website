package antoine.vaadin_website.components.pages;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class IntroductionPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Anchor resumeLink = new Anchor();

    @Override
    protected Page initContent() {
        resumeLink.setTarget("_tab");
        resumeLink.addClassName("link-to-resume");

        var page = new Page()
            .title("Antoine HAZEBROUCK | Software Engineer") // make the title more apparent, maybe move out of the card and center in above te cards
            .body(
                "Passionate and dedicated Software Engineer with two years of experience designing, implementing, and optimizating applications, particularly within complex financial systems."
            )
            .footer(resumeLink);

        return page;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        resumeLink.setHref(getTranslation("main.link-to-resume"));
        resumeLink.setText(getTranslation("main.see-resume"));
    }
}
