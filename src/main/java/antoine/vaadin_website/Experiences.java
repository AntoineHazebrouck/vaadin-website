package antoine.vaadin_website;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import antoine.vaadin_website.utils.Responsive;

public class Experiences extends VerticalLayout {
	private static final String WIDTH = "100%";

	public Experiences() {
		var education = Responsive.column(
				new H3("Parcours scolaire"),
				ExperienceCard.builder()
						.width(WIDTH)
						.height("15em")
						.title("BUT Informatique")
						.subtitle("IUT de Lille")
						.dates("2021-2024")
						.build()
						.toCard(),
				ExperienceCard.builder()
						.width(WIDTH)
						.height("15em")
						.title("Ingénieur informatique (CTI)")
						.subtitle("IMT Nord Europe - Lille")
						.dates("2024-2027")
						.build()
						.toCard())
				.alignement(Alignment.CENTER)
				.build();

		var professional = Responsive.column(
				new H3("Parcours professionnel"),
				ExperienceCard.builder()
						.width(WIDTH)
						.height("22.5em")
						.title("Apprenti ingénieur logiciel")
						.subtitle("Société Générale - La Défense")
						.dates("2023-2027")
						.build()
						.toCard())
				.alignement(Alignment.CENTER)
				.justify(JustifyContentMode.BETWEEN)
				.build();

		// add(new H3("Mon parcours"));

		add(Responsive.row(education, professional).build());
	}
}
