package antoine.vaadin_website;

import com.vaadin.flow.component.HasText.WhiteSpace;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import antoine.vaadin_website.utils.Responsive;

public class Information extends VerticalLayout {
	public Information() {
		add(new H3("Informations"));

		var col = Responsive.column(
				Responsive.row(label("Ville : "), new Span("59000, Lille"))
						.alignement(Alignment.CENTER)
						.build(),
				Responsive.row(label("Email : "), new Span("antoine.hazebrouck5@gmail.com"))
						.alignement(Alignment.CENTER)
						.build())
				.build();

		add(col);

		add(new H3("Information"));

		var col2 = new VerticalLayout();

		// col2.add(row(new H5("Ville : "), new Span("59000, Lille")));
		// col2.add(row(new H5("Email : "), new Span("antoine.hazebrouck5@gmail.com")));

		add(col2);
	}

	private static H5 label(String text) {
		var label = new H5(text);
		label.setWhiteSpace(WhiteSpace.NOWRAP);
		return label;
	}
}
