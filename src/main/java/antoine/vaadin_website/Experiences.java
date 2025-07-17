package antoine.vaadin_website;

import java.util.List;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import antoine.vaadin_website.utils.Responsive;

public class Experiences extends VerticalLayout {
	private static final String WIDTH = "100%";

	public Experiences() {
		var education = Responsive.column(
				new H3("Parcours scolaire"),
				ExperienceCard.builder()
						.width(WIDTH)
						.minHeight("15em")
						.title("BUT Informatique")
						.subtitle("IUT de Lille")
						.content(List.of( 
								new Paragraph("J'y ai appris toutes les bases de la réalisation d'applications : "),
								new UnorderedList(
										new ListItem("conception : UI/UX, design, recueil des besoins, prototypage"),
										new ListItem("développement : web, mobile, desktop"),
										new ListItem("validation : tests automatisés, go du client"),
										new ListItem("déploiement : mise en production"),
										new ListItem("gestion de projet : agilité, accompagnement client"))))
						.dates("2021-2024")
						.build()
						.toCard(),
				ExperienceCard.builder()
						.width(WIDTH)
						.minHeight("15em")
						.title("Ingénieur informatique (CTI)")
						.subtitle("IMT Nord Europe - Lille")
						.content(List.of())
						.dates("2024-2027")
						.build()
						.toCard())
				.alignement(Alignment.CENTER)
				.build();

		var professional = Responsive.column(
				new H3("Parcours professionnel"),
				ExperienceCard.builder()
						.width(WIDTH)
						.minHeight("22.5em")
						.title("Apprenti ingénieur logiciel")
						.subtitle("Société Générale - La Défense")
						.content(List.of(
								new Paragraph(
										"Dans un contexte international, j'ai créé, amélioré et maintenu une large chaîne d'outils répondant aux risques structurels et aux besoins de pilotage du groupe vis-à-vis de la direction financière. "),
								new Paragraph(
										"J'ai notamment, au sein de l'équipe data quality, implementé la consolidation, la coherence et la validation qualitative du bilan du groupe. "),
								new Paragraph(
										"J'ai aussi eu l'occasion de mener dans sa totalité un projet de calibration du bilan interne sur un socle agile, priorisant la satisfaction client. ")))
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
