package antoine.vaadin_website.views;

import java.util.List;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SkillsView extends HorizontalLayout {
	public SkillsView() {
		for (String badge : List.of(
				"Java : Spring Boot",
				"Hadoop",
				"Spark",
				"Hive",
				"Python",
				"CI/CD",
				"Dashboards",
				"Gherkin",
				"Typescript/Javascript : Angular",
				"Finance",
				"REST APIs")) {
			Span pending = new Span(badge);
			pending.getElement().getThemeList().add("badge");

			add(pending);

		}
	}
}
