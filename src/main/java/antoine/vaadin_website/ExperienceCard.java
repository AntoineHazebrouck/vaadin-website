package antoine.vaadin_website;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class ExperienceCard {
	private final String width;
	private final String minHeight;
	private final String title;
	private final String subtitle;
	private final List<Component> content;
	private final String dates;

	public Card toCard() {
		var card = new Card();
		card.setTitle(new Div(title));
		card.setSubtitle(new Div(subtitle));
		card.setWidth(width);
		card.setMinHeight(minHeight);
		card.setHeaderSuffix(new Div(dates));
		card.add(content);
		return card;
	}
}