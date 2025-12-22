package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.InnerPage;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class MegaStorageRemote
    extends Composite<InnerPage>
    implements LocaleChangeObserver {

    private final Text title = new Text("");
    private final Text subtitle = new Text("");

    private final Text p1 = new Text("");
    private final Text p2 = new Text("");
    private final Text p3 = new Text("");
    private final Text p4 = new Text("");
    private final Text p5 = new Text("");

    @Override
    protected InnerPage initContent() {
        var card = new InnerPage()
            .title(title)
            .subtitle(subtitle)
            .body(
                new Paragraph(p1),
                new Paragraph(p2),
                new Paragraph(p3),
                new Paragraph(p4),
                new Paragraph(p5),
                new Paragraph()
            );

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
