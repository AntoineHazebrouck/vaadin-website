package antoine.vaadin_website;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;

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
		var card = new Card();
		card.setTitle(new Div(title));
		card.setSubtitle(new Div(subtitle));
		card.setWidth(width);
		card.setHeight(height);
		card.setHeaderSuffix(new Div(dates));
		return card;
	}
}