package antoine.vaadin_website.views.experiences.components.cards;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.views.experiences.ExperiencesView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;

public class SocgenCard
    extends Composite<CustomCard>
    implements LocaleChangeObserver {

    Paragraph text1 = new Paragraph();
    Paragraph text2 = new Paragraph();
    Paragraph text3 = new Paragraph();

    CustomCard card = CustomCard.builder()
        .width(ExperiencesView.WIDTH)
        .minHeight("22.5em")
        .content(List.of(text1, text2, text3))
        .headerSuffix(new Text("2023-2027"))
        .build();

    @Override
    protected CustomCard initContent() {
        return card;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        card.setTitle(getTranslation("experiences.socgen.title"));
        card.setSubtitle(getTranslation("experiences.socgen.subtitle"));

        text1.setText(getTranslation("experiences.socgen.text1"));
        text2.setText(getTranslation("experiences.socgen.text2"));
        text3.setText(getTranslation("experiences.socgen.text3"));
    }
}
