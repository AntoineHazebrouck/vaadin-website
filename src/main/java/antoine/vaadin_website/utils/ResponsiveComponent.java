package antoine.vaadin_website.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Style.Display;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ResponsiveComponent extends Composite<Div> {

    private final Supplier<Component> component;
    private final Function<Component, Component> desktop;
    private final Function<Component, Component> touchscreen;

    @Override
    protected Div initContent() {
        Div div = new Div(
            desktop
                .andThen(c -> {
                    c.addClassName("only-on-desktop");
                    return c;
                })
                .apply(component.get()),
            touchscreen
                .andThen(c -> {
                    c.addClassName("only-on-touchscreen");

                    return c;
                })
                .apply(component.get())
        );

        div.getStyle().setDisplay(Display.CONTENTS);

        return div;
    }
}
