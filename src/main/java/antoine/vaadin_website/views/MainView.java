package antoine.vaadin_website.views;

import antoine.vaadin_website.components.NextPageLink;
import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Html;
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

        var image = new Image(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/960px-Cat_November_2010-1a.jpg",
            "Antoine HAZEBROUCK"
        );
        image.setMaxWidth("100%");
        image.setMaxHeight("80vh");
        image.setWidth("auto");

        add(
            Responsive.row(
                new VerticalLayout(new H1("Antoine HAZEBROUCK"), text),
                image
            )
                .justify(JustifyContentMode.AROUND)
                .build()
        );
        setAlignItems(Alignment.CENTER);

        add(new NextPageLink(ContactView.class));
    }
}
