package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

public abstract class PageSkeleton<T extends PageSkeleton<T>>
    extends Composite<Card> {

    protected final Card card = new Card();

    @Override
    protected Card initContent() {
        card.addClassName("page");

        card.setThemeName("outlined");
        card.getStyle().set("width", "100%");
        return card;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public abstract T title(Text title);

    public final T subtitle(Text subtitle) {
        card.setSubtitle(new Span(subtitle));
        return self();
    }

    public final T body(String text) {
        return body(new Paragraph(text));
    }

    public final T body(Component... components) {
        card.add(components);
        return self();
    }

    public final T footer(Component... components) {
        card.addToFooter(components);
        return self();
    }
}
