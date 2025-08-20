package antoine.vaadin_website.views.experiences.components.cards;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.views.experiences.ExperiencesView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;

public class ButInformatiqueCard
    extends Composite<CustomCard>
    implements LocaleChangeObserver {

    ListItem item1 = new ListItem();
    ListItem item2 = new ListItem();
    ListItem item3 = new ListItem();
    ListItem item4 = new ListItem();
    ListItem item5 = new ListItem();
    Paragraph text = new Paragraph();
    CustomCard card = CustomCard.builder()
        .width(ExperiencesView.WIDTH)
        .minHeight("15em")
        .content(
            List.of(text, new UnorderedList(item1, item2, item3, item4, item5))
        )
        .headerSuffix(new Text("2021-2024"))
        .build();

    @Override
    protected CustomCard initContent() {
        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card.setTitle(getTranslation("experiences.but.title"));
        card.setSubtitle(getTranslation("experiences.but.subtitle"));

        text.setText(getTranslation("experiences.but.text"));

        item1.setText(getTranslation("experiences.but.list-item1"));
        item2.setText(getTranslation("experiences.but.list-item2"));
        item3.setText(getTranslation("experiences.but.list-item3"));
        item4.setText(getTranslation("experiences.but.list-item4"));
        item5.setText(getTranslation("experiences.but.list-item5"));
    }
}
