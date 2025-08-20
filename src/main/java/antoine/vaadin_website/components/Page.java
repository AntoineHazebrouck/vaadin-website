package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;

public abstract class Page
    extends Composite<HorizontalLayout>
    implements HasDynamicTitle {

    private final VerticalLayout page = new PageContent();

    @Override
    protected HorizontalLayout initContent() {
        return new HorizontalLayout();
    }

    protected Page() {
        getStyle().setMarginLeft("auto").setMarginRight("auto");
        getContent().setAlignItems(Alignment.START);
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);

        PreviousPageLink previous = new PreviousPageLink(previous());
        previous.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
        NextPageLink next = new NextPageLink(next());
        next.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);

        getContent().add(previous);
        getContent()
            .add(Responsive.column(page, new MyFooter()).padding("0").build());
        getContent().add(next);
    }

    public abstract Class<? extends Component> previous();

    public abstract Class<? extends Component> next();

    public void add(Component... components) {
        page.add(components);
    }
}
