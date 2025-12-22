package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.SourceCodeLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import java.util.List;
import java.util.Optional;

public class Rythm
    extends Composite<Component>
    implements LocaleChangeObserver {

    Text text1 = new Text("");
    Text text2 = new Text("");
    CustomCard card = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of("https://github.com/AntoineHazebrouck/rythm")
            )
        )
        .content(
            List.of(
                new Paragraph(
                    text1,
                    new Anchor(
                        "https://osu.ppy.sh/wiki/en/Game_mode/osu%21mania",
                        "osu!mania"
                    ),
                    text2
                ),
                new Badges(
                    "Java : Spring Boot",
                    "Thymeleaf",
                    "Javascript",
                    "Typescript",
                    "Github Actions",
                    "Infra/DevOps",
                    "H2"
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
        card.setTitle(getTranslation("projects.card2.title"));

        text1.setText(getTranslation("projects.card2.text1") + " ");
        text2.setText(" " + getTranslation("projects.card2.text2"));
    }
}
