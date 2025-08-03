package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoIcon;

public class PreviousPageLink extends RouterLink {

    public PreviousPageLink(Class<? extends Component> target) {
        super(target);
        Icon icon = LumoIcon.ARROW_LEFT.create();
        icon.setSize("3em");
        add(icon);
        getElement().getThemeList().add("next-page-link");
        getStyle().setMargin("0.5em");
    }
}
