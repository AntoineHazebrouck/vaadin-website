package antoine.vaadin_website.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Page extends VerticalLayout {

    public Page() {
        super();
        setWidth("90%");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().setMargin("auto");
    }
}
