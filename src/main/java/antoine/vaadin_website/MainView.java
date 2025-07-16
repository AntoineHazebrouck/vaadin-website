package antoine.vaadin_website;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

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

		add(responsiveRow(JustifyContentMode.BETWEEN, me, image));
		// introduction

		add(new Hr());

		// contact
		var contact = new Contact();
		contact.setAlignItems(Alignment.CENTER);
		contact.setMinWidth("70%");

		var information = new Information();
		information.setAlignItems(Alignment.CENTER);
		information.setMinWidth("30%");

		add(responsiveRow(contact, information));
		// contact

		add(new Hr());

		// mon parcours
		var experiences = new Experiences();
		// experiences.setWidth("75vw");
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

		add(new Footer(new H5("footer qsdsqd")));
	}

	HorizontalLayout responsiveRow(Component... components) {
		HorizontalLayout hbar = new HorizontalLayout(components);
		hbar.setWidthFull();
		hbar.addClassNames(
				LumoUtility.FlexDirection.COLUMN,
				LumoUtility.FlexDirection.Breakpoint.Medium.ROW);
		return hbar;
	}

	Component responsiveRow(JustifyContentMode justify, Component... components) {
		var row = responsiveRow(components);
		row.setJustifyContentMode(justify);
		return row;
	}
}
