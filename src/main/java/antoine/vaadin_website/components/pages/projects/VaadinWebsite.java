package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.InnerPage;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.Optional;

public class VaadinWebsite
    extends Composite<InnerPage>
    implements LocaleChangeObserver {

    private final Text titleText = new Text("");
    private final Paragraph p1 = new Paragraph();
    private final Paragraph p2 = new Paragraph();
    private final Paragraph p3 = new Paragraph();

    @Override
    protected InnerPage initContent() {
        titleText.setText(getTranslation("projects.vaadin_website.title"));
        p1.setText(getTranslation("projects.vaadin_website.p1"));
        p2.setText(getTranslation("projects.vaadin_website.p2"));
        p3.setText(getTranslation("projects.vaadin_website.p3"));

        return new InnerPage()
            .title(titleText)
            .headerSuffix(
                new SourceCodeLink(
                    Optional.of(
                        "https://github.com/AntoineHazebrouck/vaadin-website"
                    )
                )
            )
            .body(p1, p2, p3);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        titleText.setText(getTranslation("projects.vaadin_website.title"));
        p1.setText(getTranslation("projects.vaadin_website.p1"));
        p2.setText(getTranslation("projects.vaadin_website.p2"));
        p3.setText(getTranslation("projects.vaadin_website.p3"));
    }
}
