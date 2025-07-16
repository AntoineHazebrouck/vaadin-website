package antoine.vaadin_website;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Me extends VerticalLayout {
	public Me() {
		var text = new Paragraph();
		text.add(new Html("<b style=\"font-size:1.5em;\">Ingénieur logiciel</b>"));
		text.add(new StringBuilder()
				.append(" passionné et engagé, fort de deux ans d'expérience dans la conception, l'implémentation et l'optimisation d'applications, notamment au sein de systèmes financiers complexes.")
				.toString());

		add(new VerticalLayout(new H1("Antoine HAZEBROUCK"), text));

	}
}
