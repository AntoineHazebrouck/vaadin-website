package antoine.vaadin_website.views;

import antoine.vaadin_website.Constants;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.components.Skills;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route
@PageTitle("Antoine HAZEBROUCK")
public class MainView extends Page {

    public MainView() {
        var text = new Paragraph();
        text.add(
            new Html("<b style=\"font-size:1.5em;\">Ingénieur logiciel</b>")
        );
        text.add(
            new StringBuilder()
                .append(
                    " passionné et engagé, fort de deux ans d'expérience dans la conception, l'implémentation et l'optimisation d'applications, notamment au sein de systèmes financiers complexes."
                )
                .toString()
        );

        var resumeLink = new Anchor(
            Constants.Links.RESUME,
            new Text("Voir mon CV")
        );
        resumeLink.setTarget("_tab");
        resumeLink.getStyle().setMargin("auto");
        resumeLink.getElement().getThemeList().add("link-to-resume");

        var image = new Image(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/960px-Cat_November_2010-1a.jpg",
            "Antoine HAZEBROUCK"
        );
        image.setMaxWidth("100%");
        image.setMaxHeight("75vh");
        image.setWidth("auto");

        addContent(
            Responsive.row(
                new VerticalLayout(
                    new H1("Antoine HAZEBROUCK"),
                    text,
                    resumeLink
                ),
                image
            )
                .justify(JustifyContentMode.AROUND)
                .build()
        );
        setAlignItems(Alignment.CENTER);

        addContent(new Skills());
    }

    @Override
    public Class<? extends Component> previous() {
        return ProjectsView.class;
    }

    @Override
    public Class<? extends Component> next() {
        return ContactView.class;
    }
}
