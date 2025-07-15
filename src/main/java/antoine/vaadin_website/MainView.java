package antoine.vaadin_website;

import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

	public MainView() {

		// UI.getCurrent().getPage().addBrowserWindowResizeListener(event -> {
		// add(new Text("Width : " + event.getWidth()));
		// add(new Text("Height : " + event.getHeight()));

		// UI.getCurrent().getPage().retrieveExtendedClientDetails(details -> {
		// System.out.println("Width " + details.getWindowInnerWidth());
		// System.out.println("Height " + details.getWindowInnerHeight());
		// });
		// });

		setAlignItems(FlexComponent.Alignment.CENTER);

		// introduction
		var image = new Image(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/960px-Cat_November_2010-1a.jpg",
				"Antoine HAZEBROUCK");
		image.setMaxWidth("100%");
		image.setMaxHeight("90vh");
		image.setWidth("auto");

		var me = new Me();
		me.setWidth("60vw");
		me.setAlignItems(FlexComponent.Alignment.CENTER);
		me.setJustifyContentMode(JustifyContentMode.EVENLY);
		HorizontalLayout introduction = new HorizontalLayout(
				me,
				image);
		introduction.setWidthFull();
		introduction.setAlignItems(Alignment.CENTER);
		introduction.setJustifyContentMode(JustifyContentMode.BETWEEN);
		introduction.setWrap(true);

		add(introduction);
		// introduction

		add(new Hr());

		// contact
		var contact = new Contact();
		contact.setAlignItems(Alignment.CENTER);

		var information = new Information();
		information.setAlignItems(Alignment.CENTER);
		information.setMaxWidth("30vw");

		HorizontalLayout hbar = new HorizontalLayout(contact, information);
		hbar.setWidthFull();
		add(hbar);
		// contact

		add(new Hr());

		// mon parcours
		var experiences = new Experiences();
		// experiences.setWidth("75vw");
		experiences.setWidthFull();
		experiences.setAlignItems(FlexComponent.Alignment.CENTER);
		add(experiences);
		// mon parcours

		add(new Hr());

		// mes projets
		add(new HorizontalLayout(new Projects()));
		// mes projets

		add(new Footer(new H5("footer qsdsqd")));
	}
}
