package antoine.vaadin_website.views.projects.components;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;
import java.util.Optional;

public class DataClassifier
    extends Composite<Component>
    implements LocaleChangeObserver {

    Paragraph text = new Paragraph();
    CustomCard card = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of(
                    "https://github.com/AntoineHazebrouck/equipe-J6-master"
                )
            )
        )
        .content(List.of(text, new Badges("Java", "JavaFX", "Junit")))
        .build();

    @Override
    protected Component initContent() {
        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card.setTitle(getTranslation("projects.card4.title"));
        text.setText(getTranslation("projects.card4.text"));
    }
}
