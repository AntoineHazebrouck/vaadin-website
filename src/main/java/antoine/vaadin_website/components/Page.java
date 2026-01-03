package antoine.vaadin_website.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.H2;

public class Page extends PageSkeleton<Page> {

    @Override
    protected Card initContent() {
        card.addClassName("page");

        card.setThemeName("outlined");
        card.getStyle().set("width", "100%");
        return card;
    }

    @Override
    public Page title(Text title) {
        card.setTitle(new H2(title));
        return this;
    }

    public Page centeredTitle(Text title) {
        var header = new H2(title);
        header.getStyle().setMarginLeft("auto");
        header.getStyle().setMarginRight("auto");
        card.setTitle(header);
        return this;
    }
}
