package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Paragraph;

public class MyFooter extends Footer {

    public MyFooter() {
        add(new Paragraph("© Copyright 2025 Antoine HAZEBROUCK"));
        getElement().getThemeList().add(Constants.Themes.DESKTOP_ONLY);
    }
}
