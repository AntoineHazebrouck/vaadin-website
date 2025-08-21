package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.IconFactory;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;

public class NavBarLink extends Tab {

    Paragraph desktop = new Paragraph();

    public NavBarLink(IconFactory icon, Class<? extends Component> target) {
        var touchscreen = icon.create();
        touchscreen
            .getElement()
            .getThemeList()
            .add(Constants.Themes.TOUCHSCREEN_ONLY);
        touchscreen.setSize("2em");

        desktop.getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
        desktop.getStyle().setMargin("0");

        RouterLink routerLink = new RouterLink(target);
        routerLink.add(touchscreen);
        routerLink.add(desktop);
        add(routerLink);
    }

    public void setText(String text) {
        desktop.setText(text);
    }
}
