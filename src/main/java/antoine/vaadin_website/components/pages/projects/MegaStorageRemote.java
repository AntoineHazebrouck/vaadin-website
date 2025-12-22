package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.InnerPage;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.Optional;

public class MegaStorageRemote
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
        var card = new InnerPage()
            .title(title)
            .subtitle(subtitle)
            .headerSuffix(
                new SourceCodeLink(
                    Optional.of(
                        "https://github.com/AntoineHazebrouck/MegaStorageRemote"
                    )
                )
            )
            .body(p1, p2, p3, p4, p5);

        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.megastorage.title"));
        subtitle.setText(getTranslation("projects.megastorage.subtitle"));

        p1.setText(getTranslation("projects.megastorage.p1"));
        p2.setText(getTranslation("projects.megastorage.p2"));
        p3.setText(getTranslation("projects.megastorage.p3"));
        p4.setText(getTranslation("projects.megastorage.p4"));
        p5.setText(getTranslation("projects.megastorage.p5"));
    }
}
