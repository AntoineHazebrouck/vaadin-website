package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;
import java.util.Optional;

public class AdsSocialNetwork
    extends Composite<Component>
    implements LocaleChangeObserver {

    Paragraph text1 = new Paragraph();
    Paragraph text2 = new Paragraph();
    CustomCard card5 = CustomCard.builder()
        .headerSuffix(new SourceCodeLink(Optional.empty()))
        .content(
            List.of(
                text1,
                text2,
                new Badges(
                    "Java : Spring Boot",
                    "REST API",
                    "Postgres",
                    "Agilité"
                )
            )
        )
        .build();

    @Override
    protected Component initContent() {
        return card5;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card5.setTitle(getTranslation("projects.card5.title"));
        text1.setText(getTranslation("projects.card5.text1"));
        text2.setText(getTranslation("projects.card5.text2"));
    }
}
