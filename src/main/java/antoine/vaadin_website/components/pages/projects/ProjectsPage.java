package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.utils.ResponsiveComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.function.Supplier;

public class ProjectsPage
    extends Composite<Page>
    implements LocaleChangeObserver, LayoutMixin {

    private final Text title = new Text("");

    @Override
    protected Page initContent() {
        var portfolio = new VaadinWebsite();
        var adsSocialNetwork = new AdsSocialNetwork();

        portfolio.addClassNames(LumoUtility.Flex.ONE);
        adsSocialNetwork.addClassNames(LumoUtility.Flex.ONE);

        var megaStorageRemote = centerSingleColumn(() -> new MegaStorageRemote()
        );

        var dataClassifier = centerSingleColumn(() -> new DataClassifier());

        var page = new Page()
            .body(
                Responsive.column(
                    megaStorageRemote,
                    Responsive.row(portfolio, adsSocialNetwork).build(),
                    dataClassifier
                )
                    .alignement(Alignment.CENTER)
                    .build()
            )
            .centeredTitle(title);

        return page;
    }

    private ResponsiveComponent centerSingleColumn(
        Supplier<Component> project
    ) {
        return responsiveComponent(
            project,
            c -> {
                c.getStyle().setWidth("80%");
                return c;
            },
            c -> c
        );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.title"));
    }
}
