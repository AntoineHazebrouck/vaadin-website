package antoine.vaadin_website.views.projects.components;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;
import java.util.Optional;

public class EmailAlerts
    extends Composite<Component>
    implements LocaleChangeObserver {

    Paragraph text = new Paragraph();
    ListItem listItem1 = new ListItem();
    ListItem listItem2 = new ListItem();
    ListItem listItem3 = new ListItem();

    CustomCard card = CustomCard.builder()
        .headerSuffix(new SourceCodeLink(Optional.empty()))
        .content(
            List.of(
                text,
                new UnorderedList(
                    listItem1,
                    listItem2,
                    listItem3
                ),
                new Badges(
                    "Gmail",
                    "Java : Spring Boot",
                    "Scala",
                    "Github Actions"
                )
            )
        )
        .build();

    @Override
    protected Component initContent() {
        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card.setTitle(getTranslation("projects.card3.title"));
        text.setText(getTranslation("projects.card3.text"));
        listItem1.setText(getTranslation("projects.card3.list-item1"));
        listItem2.setText(getTranslation("projects.card3.list-item2"));
        listItem3.setText(getTranslation("projects.card3.list-item3"));
    }
}
