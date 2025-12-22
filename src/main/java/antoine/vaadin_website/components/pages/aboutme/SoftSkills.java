package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.AccordionPanel;

public class SoftSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin {

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            "Soft skills",
            list(
                "Proactive",
                "Teamworker",
                "Autonomous",
                "Curious",
                "Communicative",
                "Adaptable",
                "Passionate"
            )
        );
    }
}
