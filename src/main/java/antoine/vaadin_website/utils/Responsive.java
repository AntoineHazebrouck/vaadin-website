package antoine.vaadin_website.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Responsive {

    private final FlexComponent layout;

    private JustifyContentMode justify;
    private Alignment alignment;
    private boolean wrap = false;

    public static Responsive row(Component... children) {
        return new Responsive(new HorizontalLayout(children));
    }

    public static Responsive column(Component... children) {
        return new Responsive(new VerticalLayout(children));
    }

    public Responsive justify(JustifyContentMode justify) {
        this.justify = justify;
        return this;
    }

    public Responsive alignement(Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    public Responsive wrap() {
        this.wrap = true;
        return this;
    }

    public Component build() {
        if (justify != null) {
            layout.setJustifyContentMode(justify);
        }

        if (alignment != null) {
            layout.setAlignItems(alignment);
        }

        layout.setWidthFull();

        switch (layout) {
            case HorizontalLayout then -> {
                if (wrap) {
                    then.setWrap(wrap);
                } else {
                    layout.addClassNames(
                        LumoUtility.FlexDirection.COLUMN,
                        LumoUtility.FlexDirection.Breakpoint.Medium.ROW
                    );
                }
            }
            case VerticalLayout then -> {
                layout.addClassNames(LumoUtility.FlexDirection.COLUMN);
            }
            default -> {}
        }

        return (Component) layout;
    }
}
