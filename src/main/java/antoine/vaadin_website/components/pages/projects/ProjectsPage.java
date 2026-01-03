package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ProjectsPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final Text title = new Text("");

    @Override
    protected Page initContent() {
        Component portfolio = new VaadinWebsite();
        Component dataClassifier = new DataClassifier();
        Component adsSocialNetwork = new AdsSocialNetwork();
        Component megaStorageRemote = new MegaStorageRemote();
        Component filler = new Paragraph();

        portfolio.addClassNames(LumoUtility.Flex.ONE);
        dataClassifier.addClassNames(LumoUtility.Flex.ONE);
        adsSocialNetwork.addClassNames(LumoUtility.Flex.ONE);
        megaStorageRemote.addClassNames(LumoUtility.Flex.ONE);
        filler.addClassNames(LumoUtility.Flex.ONE);

        var page = new Page()
            .body(
                Responsive.column(
                    Responsive.row(megaStorageRemote).build(),
                    Responsive.row(portfolio, adsSocialNetwork).build(),
                    Responsive.row(dataClassifier, filler).build()
                ).build()
            )
            .centeredTitle(title);

        return page;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.title"));
    }
}
