package antoine.vaadin_website.views.contact.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;

public class DrawingsDialog extends Composite<Dialog> {
	@Override
	protected Dialog initContent() {
		var drawing1 = new Image();
		return new Dialog(drawing1);
	}

	public void open() {
		getContent().open();
	}
}
