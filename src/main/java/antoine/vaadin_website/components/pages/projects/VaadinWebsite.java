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

    private final com.vaadin.flow.component.Text titleText = new com.vaadin.flow.component.Text("");
    private final com.vaadin.flow.component.html.Paragraph p1 = new com.vaadin.flow.component.html.Paragraph();
    private final com.vaadin.flow.component.html.Paragraph p2 = new com.vaadin.flow.component.html.Paragraph();
    private final com.vaadin.flow.component.html.Paragraph p3 = new com.vaadin.flow.component.html.Paragraph();

    @Override
    protected InnerPage initContent() {
        // initialize texts from current locale
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
