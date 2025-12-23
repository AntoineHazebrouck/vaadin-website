package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import java.util.List;
import lombok.Builder;

// TODO
@Deprecated(forRemoval = true)
@Builder
public class CustomCard extends Composite<Card> {

    private final String width;
    private final String minWidth;
    private final String minHeight;
    private final List<Component> content;
    private final Component headerSuffix;

    private final Div title;
    private final Div subtitle;

    public static class CustomCardBuilder {

        private Div title = new Div();
        private Div subtitle = new Div();

        public CustomCardBuilder title(String title) {
            this.title.setText(title);
            return this;
        }

        public CustomCardBuilder subtitle(String subtitle) {
            this.subtitle.setText(subtitle);
            return this;
        }
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubtitle(String subtitle) {
        this.subtitle.setText(subtitle);
    }

    @Override
    protected Card initContent() {
        var card = new Card();
        card.setTitle(new Div(title));
        card.setSubtitle(new Div(subtitle));
        card.setWidth(width);
        card.setMinWidth(minWidth);
        card.setMinHeight(minHeight);
        card.setHeaderSuffix(new Div(headerSuffix));
        card.add(content);
        return card;
    }
}
