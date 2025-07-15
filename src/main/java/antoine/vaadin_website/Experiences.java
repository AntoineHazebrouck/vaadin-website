package antoine.vaadin_website;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Experiences extends VerticalLayout {
	private static final String WIDTH = "40vw";

	public Experiences() {
		var education = new VerticalLayout();
		var professional = new VerticalLayout();

		var but = ExperienceCard.builder()
				.width(WIDTH)
				.height("20vh")
				.title("BUT Informatique")
				.subtitle("IUT de Lille")
				.dates("2021-2024")
				.build()
				.toCard();

		var inge = ExperienceCard.builder()
				.width(WIDTH)
				.height("20vh")
				.title("Ingénieur informatique (CTI)")
				.subtitle("IMT Nord Europe - Lille")
				.dates("2024-2027")
				.build()
				.toCard();

		var socgen = ExperienceCard.builder()
				.width(WIDTH)
				.height("30vh")
				.title("Apprenti ingénieur logiciel")
				.subtitle("Société Générale - La Défense")
				.dates("2023-2027")
				.build()
				.toCard();

		add(new H3("Mon parcours"));

		education.add(but, inge);

		professional.setJustifyContentMode(JustifyContentMode.END);
		professional.add(socgen);

		add(new HorizontalLayout(education, professional));
	}
}
