package antoine.vaadin_website.views.projects.components;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import java.util.List;
import java.util.stream.Stream;

public class Badges extends Composite<Component> {

    private final List<String> labels;

    public Badges(String... labels) {
        this.labels = Stream.of(labels).toList();
    }

    @Override
    protected Component initContent() {
        return Responsive.row(
            labels
                .stream()
                .map(label -> {
                    Span pending = new Span(label);
                    pending.getElement().getThemeList().add("badge");
                    pending.getStyle().setMargin("4px");
                    return pending;
                })
                .toArray(Component[]::new)
        )
            .justify(JustifyContentMode.EVENLY)
            .wrap()
            .build();
    }
}
