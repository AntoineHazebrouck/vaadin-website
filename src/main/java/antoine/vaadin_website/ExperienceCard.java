package antoine.vaadin_website;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
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
	private final List<String> badges;

	public Card toCard() {
		var card = new Card();
		card.setTitle(new Div(title));
		card.setSubtitle(new Div(subtitle));
		card.setWidth(width);
		card.setHeight(height);
		card.setHeaderSuffix(new Div(dates));

		var hbar2 = new HorizontalLayout();
		hbar2.setAlignItems(Alignment.CENTER);
		hbar2.setMargin(true);
		hbar2.setWrap(true);
		for (String badge : Optional.ofNullable(badges).orElse(new ArrayList<>())) {
			Span pending = new Span(badge);
			pending.getElement().getThemeList().add("badge");

			hbar2.add(pending);
		}
		card.add(hbar2);
		return card;
	}
}