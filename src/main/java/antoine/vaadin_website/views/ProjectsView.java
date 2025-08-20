package antoine.vaadin_website.views;

import antoine.vaadin_website.components.CustomCard;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.components.SourceCodeLink;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Route("projects")
public class ProjectsView extends Page implements LocaleChangeObserver {

    private H1 title = new H1();

    private CustomCard card1 = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of(
                    "https://github.com/AntoineHazebrouck/vaadin-website"
                )
            )
        )
        .content(List.of(badges("Java : Spring Boot", "Vaadin Flow", "Heroku")))
        .build();

    private Text card2text1 = new Text("");
    private Text card2text2 = new Text("");
    private CustomCard card2 = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of("https://github.com/AntoineHazebrouck/rythm")
            )
        )
        .content(
            List.of(
                new Paragraph(
                    card2text1,
                    new Anchor(
                        "https://osu.ppy.sh/wiki/en/Game_mode/osu%21mania",
                        "osu!mania"
                    ),
                    card2text2
                ),
                badges(
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

    private Paragraph card3text = new Paragraph();
    private ListItem card3listItem1 = new ListItem();
    private ListItem card3listItem2 = new ListItem();
    private ListItem card3listItem3 = new ListItem();
    private CustomCard card3 = CustomCard.builder()
        .headerSuffix(new SourceCodeLink(Optional.empty()))
        .content(
            List.of(
                card3text,
                new UnorderedList(
                    card3listItem1,
                    card3listItem2,
                    card3listItem3
                ),
                badges("Gmail", "Java : Spring Boot", "Scala", "Github Actions")
            )
        )
        .build();

    private Paragraph card4text = new Paragraph();
    private CustomCard card4 = CustomCard.builder()
        .headerSuffix(
            new SourceCodeLink(
                Optional.of(
                    "https://github.com/AntoineHazebrouck/equipe-J6-master"
                )
            )
        )
        .content(List.of(card4text, badges("Java", "JavaFX", "Junit")))
        .build();

    private Paragraph card5text1 = new Paragraph();
    private Paragraph card5text2 = new Paragraph();
    private CustomCard card5 = CustomCard.builder()
        .headerSuffix(new SourceCodeLink(Optional.of("TODO")))
        .content(
            List.of(
                card5text1,
                card5text2,
                badges("Java : Spring Boot", "REST API", "Postgres", "Agilité")
            )
        )
        .build();

    public ProjectsView() {
        card1.addClassNames(LumoUtility.Flex.ONE);
        card2.addClassNames(LumoUtility.Flex.ONE);
        card3.addClassNames(LumoUtility.Flex.ONE);
        card4.addClassNames(LumoUtility.Flex.ONE);
        card5.addClassNames(LumoUtility.Flex.ONE);

        addContent(title);
        addContent(Responsive.row(card1, card2).build());
        addContent(Responsive.row(card3, card4).build());
        addContent(Responsive.row(card5).build());
    }

    private static Component badges(String... labels) {
        return Responsive.row(
            Stream.of(labels).map(ProjectsView::badge).toArray(Component[]::new)
        )
            .justify(JustifyContentMode.EVENLY)
            .wrap()
            .build();
    }

    private static Span badge(String text) {
        Span pending = new Span(text);
        pending.getElement().getThemeList().add("badge");
        pending.getStyle().setMargin("4px");
        return pending;
    }

    @Override
    public Class<? extends Component> previous() {
        return ExperiencesView.class;
    }

    @Override
    public Class<? extends Component> next() {
        return MainView.class;
    }

    @Override
    public String getPageTitle() {
        return getTranslation("projects.page-title");
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        title.setText(getTranslation("projects.title"));

        card1.setTitle(getTranslation("projects.card1.title"));

        card2.setTitle(getTranslation("projects.card2.title"));
        card2text1.setText(getTranslation("projects.card2.text1") + " ");
        card2text2.setText(" " + getTranslation("projects.card2.text2"));

        card3.setTitle(getTranslation("projects.card3.title"));
        card3text.setText(getTranslation("projects.card3.text"));
        card3listItem1.setText(getTranslation("projects.card3.list-item1"));
        card3listItem2.setText(getTranslation("projects.card3.list-item2"));
        card3listItem3.setText(getTranslation("projects.card3.list-item3"));

        card4.setTitle(getTranslation("projects.card4.title"));
        card4text.setText(getTranslation("projects.card4.text"));

        card5.setTitle(getTranslation("projects.card5.title"));
        card5text1.setText(getTranslation("projects.card5.text1"));
        card5text2.setText(getTranslation("projects.card5.text2"));
    }
}
