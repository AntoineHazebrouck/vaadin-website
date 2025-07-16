package antoine.vaadin_website;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Information extends VerticalLayout {
	public Information() {
		add(new H3("Informations"));

		var col = new VerticalLayout();

		col.add(row(new H5("Ville : "), new Span("59000, Lille")));
		col.add(row(new H5("Email : "), new Span("antoine.hazebrouck5@gmail.com")));

		add(col);

		add(new H3("Information"));

		var col2 = new VerticalLayout();

		col2.add(row(new H5("Ville : "), new Span("59000, Lille")));
		col2.add(row(new H5("Email : "), new Span("antoine.hazebrouck5@gmail.com")));

		add(col2);
	}

	private static HorizontalLayout row(Component... components) {
		HorizontalLayout row = new HorizontalLayout(components);
		row.setAlignItems(Alignment.CENTER);
		return row;
	}
}
