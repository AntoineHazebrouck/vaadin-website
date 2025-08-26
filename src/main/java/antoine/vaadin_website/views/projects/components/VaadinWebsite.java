package antoine.vaadin_website.views.projects.components;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import java.util.List;
import java.util.Optional;

public class VaadinWebsite extends Composite<Component> implements LocaleChangeObserver{

    CustomCard card = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of(
                    "https://github.com/AntoineHazebrouck/vaadin-website"
                )
            )
        )
        .content(
            List.of(new Badges("Java : Spring Boot", "Vaadin Flow", "Heroku"))
        )
        .build();

    @Override
    protected Component initContent() {
        return card;
    }

	@Override
	public void localeChange(LocaleChangeEvent event) {
		card.setTitle(getTranslation("projects.card1.title"));
	}
}
