package antoine.vaadin_website.components;

import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailTrackingAnchor extends Composite<Anchor> {

    private final String message;

    @Override
    protected Anchor initContent() {
        var link = new Anchor();

        link
            .getElement()
            .addEventListener("click", event -> {
                EmailServices.send(
                    Args.builder().subject(message).text(message).build(),
                    true
                );
            });

        return link;
    }

    public EmailTrackingAnchor newTab() {
        this.getContent().setTarget("_tab");
        return this;
    }

    public EmailTrackingAnchor setText(String text) {
        this.getContent().setText(text);
        return this;
    }

    public EmailTrackingAnchor setHref(String text) {
        this.getContent().setHref(text);
        return this;
    }
}
