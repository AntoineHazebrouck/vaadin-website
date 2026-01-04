package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ProjectsPage
    extends Composite<Page>
    implements LocaleChangeObserver, LayoutMixin {

    private final Text title = new Text("");

    @Override
    protected Page initContent() {
        Component portfolio = new VaadinWebsite();
        Component dataClassifier = new DataClassifier();
        Component adsSocialNetwork = new AdsSocialNetwork();

        var megaStorageRemote = responsiveComponent(
            () -> new MegaStorageRemote(),
            c -> {
                c.getStyle().setWidth("80%");
                return c;
            },
            c -> c
        );
        // Component megaStorageRemote = new MegaStorageRemote();
        // megaStorageRemote.getStyle().setWidth("80%");

        Component filler = new Paragraph();

        portfolio.addClassNames(LumoUtility.Flex.ONE);
        dataClassifier.addClassNames(LumoUtility.Flex.ONE);
        adsSocialNetwork.addClassNames(LumoUtility.Flex.ONE);
        // megaStorageRemote.addClassNames(LumoUtility.Flex.ONE);
        filler.addClassNames(LumoUtility.Flex.ONE);

        var page = new Page()
            .body(
                Responsive.column(
                    megaStorageRemote,
                    Responsive.row(portfolio, adsSocialNetwork).build(),
                    Responsive.row(dataClassifier, filler).build()
                )
                    .alignement(Alignment.CENTER)
                    .build()
            )
            .centeredTitle(title);

        return page;
    }

    // private Component[] megaStorageRemoteResponsive() {
    //     Component megaStorageRemote = new MegaStorageRemote();
    //     megaStorageRemote.getStyle().setWidth("80%");
    // }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.title"));
    }
}
