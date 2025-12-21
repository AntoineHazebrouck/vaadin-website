package antoine.vaadin_website.components;

import antoine.vaadin_website.Constants;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Paragraph;

public class CopyrightFooter extends Footer {

    public CopyrightFooter() {
        add(new Paragraph("© Copyright 2025 Antoine HAZEBROUCK"));
        addClassName(Constants.Themes.DESKTOP_ONLY);
    }
}
