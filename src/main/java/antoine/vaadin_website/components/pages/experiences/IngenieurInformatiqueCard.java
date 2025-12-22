package antoine.vaadin_website.components.pages.experiences;

import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import antoine.vaadin_website.components.CustomCard;

public class IngenieurInformatiqueCard
    extends Composite<CustomCard>
    implements LocaleChangeObserver {

    CustomCard card = CustomCard.builder()
        .width("100%")
        .minHeight("15em")
        .content(List.of())
        .headerSuffix(new Text("2024-2027"))
        .build();

    @Override
    protected CustomCard initContent() {
        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card.setTitle(
            getTranslation("experiences.ingenieur-informatique.title")
        );
        card.setSubtitle(
            getTranslation("experiences.ingenieur-informatique.subtitle")
        );
    }
}
