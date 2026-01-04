package antoine.vaadin_website.components.pages.projects;

import java.util.Optional;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import antoine.vaadin_website.components.InnerPage;
import antoine.vaadin_website.components.MoreDetails;
import antoine.vaadin_website.components.SourceCodeLink;

public class AdsSocialNetwork
    extends Composite<InnerPage>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");
    private final Paragraph p1 = new Paragraph("");
    private final Paragraph p2 = new Paragraph("");
    private final Paragraph p3 = new Paragraph("");
    private final Paragraph p4 = new Paragraph("");
    private final Paragraph p5 = new Paragraph("");

    @Override
    protected InnerPage initContent() {
        return new InnerPage()
            .title(title)
            .subtitle(subtitle)
            .headerSuffix(new SourceCodeLink(Optional.empty()))
            .body(p1, new MoreDetails(p2, p3, p4, p5));
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.services-ads.title"));
        subtitle.setText(getTranslation("projects.services-ads.subtitle"));
        p1.setText(getTranslation("projects.services-ads.p1"));
        p2.setText(getTranslation("projects.services-ads.p2"));
        p3.setText(getTranslation("projects.services-ads.p3"));
        p4.setText(getTranslation("projects.services-ads.p4"));
        p5.setText(getTranslation("projects.services-ads.p5"));
    }
}
