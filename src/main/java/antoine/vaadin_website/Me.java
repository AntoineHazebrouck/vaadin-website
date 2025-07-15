package antoine.vaadin_website;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Me extends VerticalLayout {
	public Me() {
		add(new VerticalLayout(new H1("Antoine HAZEBROUCK"), new H2("Ingénieur logiciel")));
		add(new Text("Je me présente ..."));
	}
}
