package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.AutoplayVideo;
import antoine.vaadin_website.components.InnerPage;
import antoine.vaadin_website.components.SourceCodeLink;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.Optional;

public class DataClassifier
    extends Composite<InnerPage>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");
    private final Paragraph p1 = new Paragraph();
    private final Paragraph p2 = new Paragraph();
    private final Paragraph p3 = new Paragraph();

    @Override
    protected InnerPage initContent() {
        return new InnerPage()
            .title(title)
            .subtitle(subtitle)
            .headerSuffix(
                new SourceCodeLink(
                    Optional.of(
                        "https://github.com/AntoineHazebrouck/equipe-J6-master"
                    )
                )
            )
            .body(
                p1,
                p2,
                p3,
                Responsive.column(
                    new AutoplayVideo("videos/data-explorer-demo.mp4")
                )
                    .alignement(Alignment.CENTER)
                    .build()
            );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.data-classifier.title"));
        subtitle.setText(getTranslation("projects.data-classifier.subtitle"));
        p1.setText(getTranslation("projects.data-classifier.p1"));
        p2.setText(getTranslation("projects.data-classifier.p2"));
        p3.setText(getTranslation("projects.data-classifier.p3"));
    }
}
