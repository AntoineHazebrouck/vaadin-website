package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;

public abstract class Page extends HorizontalLayout implements HasDynamicTitle {

    private final VerticalLayout content = new PageContent();

    protected Page() {
        super();
        getStyle().setMarginLeft("auto").setMarginRight("auto");
        setAlignItems(Alignment.START);
        setJustifyContentMode(JustifyContentMode.CENTER);

        PreviousPageLink previous = new PreviousPageLink(previous());
        previous.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
        NextPageLink next = new NextPageLink(next());
        next.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);

        add(previous);
        add(Responsive.column(content, new MyFooter()).padding("0").build());
        add(next);
    }

    public abstract Class<? extends Component> previous();

    public abstract Class<? extends Component> next();

    public void addContent(Component... components) {
        content.add(components);
    }
}
