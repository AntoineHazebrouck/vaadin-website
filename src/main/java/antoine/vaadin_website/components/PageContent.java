package antoine.vaadin_website.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PageContent extends VerticalLayout {

    public PageContent() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().setMargin("auto");
        getElement().getThemeList().add("page");
    }
}
