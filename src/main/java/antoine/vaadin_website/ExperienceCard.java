package antoine.vaadin_website;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class ExperienceCard {
	private final String width;
	private final String height;
	private final String title;
	private final String subtitle;
	private final String dates;

	public Card toCard() {
		HorizontalLayout hbar = new HorizontalLayout(
				new Div(title),
				new Text(dates));
		hbar.setJustifyContentMode(JustifyContentMode.BETWEEN);

		var card = new Card();
		card.setTitle(hbar);
		card.setSubtitle(new Div(subtitle));
		card.setWidth(width);
		card.setHeight(height);
		return card;
	}
}