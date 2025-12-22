package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Html;
import lombok.Getter;
import lombok.Setter;

// @Tag("b")
public class Bold extends Composite<Component> implements HasText {

    @Getter
    @Setter
    private String text;

    @Override
    protected Component initContent() {
        return new Html("<b style=\"font-size:1.5em;\"></b>");
    }
}
