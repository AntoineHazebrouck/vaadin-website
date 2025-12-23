package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class SoftSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin, LocaleChangeObserver {

    private final Text title = new Text("");

    private final Text proactive = new Text("");
    private final Text teamworker = new Text("");
    private final Text autonomous = new Text("");
    private final Text curious = new Text("");

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            title,
            list(
                proactive,
                teamworker,
                autonomous,
                curious
            )
        );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("about.soft-skills.title"));
        proactive.setText(getTranslation("about.soft-skills.proactive"));
        teamworker.setText(getTranslation("about.soft-skills.teamworker"));
        autonomous.setText(getTranslation("about.soft-skills.autonomous"));
        curious.setText(getTranslation("about.soft-skills.curious"));
    }
}
