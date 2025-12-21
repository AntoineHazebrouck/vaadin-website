package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Paragraph;

public class Page extends Composite<Card> {

    private final Card card = new Card();

    @Override
    protected Card initContent() {
        card.setThemeName("outlined");
        card.getStyle().set("width", "100%");
        return card;
    }

    public Page title(String title) {
        card.setTitle(title);
        return this;
    }

    public Page body(String text) {
        return body(new Paragraph(text));
    }

    public Page body(Component... components) {
        card.add(components);
        return this;
    }

    public Page footer(Component... components) {
        card.addToFooter(components);
        return this;
    }
}
