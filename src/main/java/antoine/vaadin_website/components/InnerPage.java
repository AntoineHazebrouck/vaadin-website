package antoine.vaadin_website.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.H4;

public class InnerPage extends PageSkeleton<InnerPage> {

    @Override
    protected Card initContent() {
        card.getStyle().set("width", "100%");
        return card;
    }

    @Override
    public InnerPage title(Text title) {
        card.setTitle(new H4(title));
        return this;
    }
}
