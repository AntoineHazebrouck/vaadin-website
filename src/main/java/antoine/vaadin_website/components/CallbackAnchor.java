package antoine.vaadin_website.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.dom.DomEventListener;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CallbackAnchor extends Composite<Anchor> {

    private final DomEventListener callback;

    @Override
    protected Anchor initContent() {
        var link = new Anchor();

        link.addClassName("link-to-resume");

        link.getElement().addEventListener("click", callback);

        return link;
    }

    public CallbackAnchor newTab() {
        this.getContent().setTarget("_tab");
        return this;
    }

    public CallbackAnchor setText(String text) {
        this.getContent().setText(text);
        return this;
    }

    public CallbackAnchor setHref(String text) {
        this.getContent().setHref(text);
        return this;
    }
}
