package antoine.vaadin_website;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormRow;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class Contact extends VerticalLayout {
	public Contact() {
		TextField firstName = new TextField("Prénom", "John");
		TextField lastName = new TextField("Nom", "Doe");
		EmailField email = new EmailField("Email", "john.doe@example.com");
		TextArea message = new TextArea("Message", "Je vous contacte au sujet de ...");
		message.setHeight("6em");

		FormLayout formLayout = new FormLayout();
		formLayout.setAutoResponsive(true);
		formLayout.setExpandFields(true);
		formLayout.setExpandColumns(true);

		formLayout.addFormRow(firstName, lastName, email);

		var row2 = new FormRow();
		row2.add(message, 3);
		formLayout.add(row2);

		formLayout.addFormRow(new Button("Envoyer", event -> {
			Notification.show("Done");
		}));

		// var hbar = new HorizontalLayout(formLayout);
		// hbar.setWidthFull();
		// hbar.setJustifyContentMode(JustifyContentMode.CENTER);
		add(new H3("Me contacter"));
		add(formLayout);
	}
}
