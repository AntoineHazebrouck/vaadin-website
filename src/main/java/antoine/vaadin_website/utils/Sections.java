package antoine.vaadin_website.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Section;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sections {
	private final Component component;

	public static Sections of(Component component) {
		return new Sections(component);
	}

	public Section id(String id) {
		var section = new Section(component);
		section.setId(id);
		return section;
	}
}
