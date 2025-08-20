package antoine.vaadin_website.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.Optional;

public class SourceCodeLink
    extends Composite<Anchor>
    implements LocaleChangeObserver {

    private final Anchor anchor;

    public SourceCodeLink(Optional<String> to) {
        if (to.isEmpty()) {
            anchor = new Anchor("");
            anchor.setTarget("_tab");
            anchor.setEnabled(false);
        } else {
            anchor = new Anchor(to.get());
            anchor.setTarget("_tab");
        }
    }

    @Override
    protected Anchor initContent() {
        return anchor;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        anchor.setText(getTranslation("constants.source-code"));
    }
}
