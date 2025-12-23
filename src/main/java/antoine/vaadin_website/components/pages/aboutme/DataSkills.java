package antoine.vaadin_website.components.pages.aboutme;

import antoine.vaadin_website.utils.LayoutMixin;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class DataSkills
    extends Composite<AccordionPanel>
    implements LayoutMixin, LocaleChangeObserver {

    private final Text header = new Text("");
    private final Text item1 = new Text("");
    private final Text item2 = new Text("");
    private final Text item3 = new Text("");
    private final Text item4 = new Text("");
    private final Text item5 = new Text("");

    @Override
    protected AccordionPanel initContent() {
        return new AccordionPanel(
            header,
            list(item1, item2, item3, item4, item5)
        );
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        header.setText(getTranslation("about.hard-skills.data.title"));
        item1.setText(getTranslation("about.hard-skills.data.item1"));
        item2.setText(getTranslation("about.hard-skills.data.item2"));
        item3.setText(getTranslation("about.hard-skills.data.item3"));
        item4.setText(getTranslation("about.hard-skills.data.item4"));
        item5.setText(getTranslation("about.hard-skills.data.item5"));
    }
}
