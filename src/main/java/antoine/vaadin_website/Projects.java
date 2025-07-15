package antoine.vaadin_website;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Projects extends HorizontalLayout {
	public Projects() {
		var card1 = new Card();
		card1.setTitle("Portfolio");
		add(card1);
	}
}
