package antoine.vaadin_website;

import antoine.vaadin_website.utils.Responsive;
import antoine.vaadin_website.utils.Sections;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style.Position;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public static final String appBarOffset = "4em";

    public MainView() {
        setAlignItems(FlexComponent.Alignment.CENTER);

        // appBar
        var appBar = new MenuBar();
        // appBar.setWidthFull();

        appBar.addItem(new Anchor("#home", new Text("Accueil")));
        appBar.addItem(new Anchor("#contact", new Text("Contact")));
        appBar.addItem(new Anchor("#experiences", new Text("Parcours")));
        appBar.addItem(new Anchor("#projects", new Text("Projets")));

        var wrap = new HorizontalLayout();
        wrap.setJustifyContentMode(JustifyContentMode.CENTER);
        wrap.setWidthFull();
        wrap.setMinHeight(appBarOffset);
        wrap
            .getStyle()
            .setPosition(Position.FIXED)
            .setTop("0")
            .setBackground("white")
            .setBorderBottom("solid")
            .setZIndex(Integer.MAX_VALUE)
            .setPadding("5px");

        var appBar2 = new MenuBar();
        var linkToResume = new Anchor(
            "/ANTOINE_HAZEBROUCK_CV.pdf",
            new Text("CV")
        );
        linkToResume.setTarget("_tab");
        appBar2.addItem(linkToResume);

        wrap.add(
            Responsive.row(new H1("AH"), appBar, appBar2)
                .alignement(Alignment.CENTER)
                .justify(JustifyContentMode.AROUND)
                .build()
        );
        add(wrap);
        // appBar

        // introduction
        var image = new Image(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/960px-Cat_November_2010-1a.jpg",
            "Antoine HAZEBROUCK"
        );
        image.setMaxWidth("100%");
        image.setMaxHeight("90vh");
        image.setWidth("auto");

        var me = new Me();
        me.setAlignItems(FlexComponent.Alignment.CENTER);
        me.setJustifyContentMode(JustifyContentMode.EVENLY);
        me.setMinHeight("90vh");

        add(
            Sections.of(
                Responsive.row(me, image)
                    .justify(JustifyContentMode.BETWEEN)
                    .build()
            ).id("home")
        );
        // introduction

        add(new Hr());

        // contact
        var contact = new Contact();
        contact.setAlignItems(Alignment.CENTER);

        var information = new Information();
        information.setAlignItems(Alignment.CENTER);

        add(
            Sections.of(Responsive.row(contact, information).build()).id(
                "contact"
            )
        );
        // add(Responsive.row(contact, information).build());
        // contact

        add(new Hr());

        // mon parcours
        var experiences = new Experiences();
        experiences.setWidthFull();
        experiences.setAlignItems(FlexComponent.Alignment.CENTER);
        add(Sections.of(experiences).id("experiences"));

        var skills = new Skills();
        skills.setAlignItems(Alignment.CENTER);
        skills.setJustifyContentMode(JustifyContentMode.AROUND);
        skills.setWrap(true);
        skills.setWidth("70vw");
        add(skills);
        // mon parcours

        add(new Hr());

        // mes projets
        add(Sections.of(new Projects()).id("projects"));
        // mes projets

        add(new Hr());

        add(
            new Footer(
                new HtmlContainer(
                    "i",
                    new Text(
                        "© 2025 Antoine HAZEBROUCK. Tous droits réservés."
                    )
                )
            )
        );
    }
}
