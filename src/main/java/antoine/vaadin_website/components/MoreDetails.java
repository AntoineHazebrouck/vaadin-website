package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class MoreDetails
    extends Composite<Details>
    implements LocaleChangeObserver {

    private final Text summary = new Text("");
    private final Component[] components;

    public MoreDetails(Component... components) {
        this.components = components;
    }

    @Override
    protected Details initContent() {
        return new Details(summary, components);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        summary.setText(getTranslation("constants.more-details"));
    }
}
