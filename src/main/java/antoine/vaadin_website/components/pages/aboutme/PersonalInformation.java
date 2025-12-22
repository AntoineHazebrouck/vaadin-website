package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.Span;

public class PersonalInformation
    extends Composite<AccordionPanel>
    implements LayoutMixin {

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            "Personal information",
            Responsive.column(
                new Span("+33 6 51 73 08 05"),
                new Span("antoine.hazebrouck5@gmail.com"),
                new Span("LinkedIn TODO"),
                new Span("59000, Lille"),
                new Span("French driving license + car")
            )
                .withoutSpacing()
                .build()
        );
    }
}
