package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class Page extends HorizontalLayout {

    private final VerticalLayout content = new VerticalLayout();

    protected Page() {
        super();
        getStyle().setMarginLeft("auto").setMarginRight("auto");
        setAlignItems(Alignment.START);
        setJustifyContentMode(JustifyContentMode.CENTER);
        content.setAlignItems(Alignment.CENTER);
        content.setJustifyContentMode(JustifyContentMode.CENTER);
        content.getStyle().setMargin("auto");

        PreviousPageLink previous = new PreviousPageLink(previous());
        previous.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
        NextPageLink next = new NextPageLink(next());
        next.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);

        addToStart(previous);
        addToMiddle(content);
        addToEnd(next);
    }

    public abstract Class<? extends Component> previous();

    public abstract Class<? extends Component> next();

    public void addContent(Component... components) {
        content.add(components);
    }
}
