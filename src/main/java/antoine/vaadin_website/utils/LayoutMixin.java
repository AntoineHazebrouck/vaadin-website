package antoine.vaadin_website.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface LayoutMixin {
    default ResponsiveComponent responsiveComponent(
        Supplier<Component> component,
        Function<Component, Component> desktop,
        Function<Component, Component> touchscreen
    ) {
        return new ResponsiveComponent(component, desktop, touchscreen);
    }

    default UnorderedList list(Text... text) {
        var list = new UnorderedList();
        list.getStyle().setMargin("0");
        for (var string : text) {
            list.add(new ListItem(string));
        }
        return list;
    }

    default UnorderedList list(String... text) {
        return list(Stream.of(text).map(Text::new).toArray(Text[]::new));
    }
}
