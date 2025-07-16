package antoine.vaadin_website;

import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import antoine.vaadin_website.utils.Responsive;

@Route
public class MainView extends VerticalLayout {

	public MainView() {
		setAlignItems(FlexComponent.Alignment.CENTER);

		// introduction
		var image = new Image(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/960px-Cat_November_2010-1a.jpg",
				"Antoine HAZEBROUCK");
		image.setMaxWidth("100%");
		image.setMaxHeight("90vh");
		image.setWidth("auto");

		var me = new Me();
		me.setAlignItems(FlexComponent.Alignment.CENTER);
		me.setJustifyContentMode(JustifyContentMode.EVENLY);
		me.setMinHeight("90vh");

		add(Responsive.row(me, image).justify(JustifyContentMode.BETWEEN).build());
		// introduction

		add(new Hr());

		// contact
		var contact = new Contact();
		contact.setAlignItems(Alignment.CENTER);

		var information = new Information();
		information.setAlignItems(Alignment.CENTER);

		add(Responsive.row(contact, information).build());
		// contact

		add(new Hr());

		// mon parcours
		var experiences = new Experiences();
		experiences.setWidthFull();
		experiences.setAlignItems(FlexComponent.Alignment.CENTER);
		add(experiences);
		// mon parcours

		// skills
		var skills = new Skills();
		skills.setAlignItems(Alignment.CENTER);
		skills.setJustifyContentMode(JustifyContentMode.AROUND);
		skills.setWrap(true);
		skills.setWidth("70vw");
		add(skills);
		// skills

		add(new Hr());

		// mes projets
		add(new HorizontalLayout(new Projects()));
		// mes projets

		add(new Hr());

		add(new Footer(new HtmlContainer("i", new Text("© 2025 Antoine HAZEBROUCK. Tous droits réservés."))));
	}

}
