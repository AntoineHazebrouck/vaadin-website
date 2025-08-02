package antoine.vaadin_website.views;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormRow;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.Data;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Route("contact")
@PageTitle("Contact")
public class ContactView extends Page {

    @Data
    private static class ContactForm {

        private String firstname;
        private String lastname;
        private String email;
        private String message;
    }

    public ContactView(JavaMailSender emails) {
        Binder<ContactForm> binder = new Binder<>(ContactForm.class);

        TextField firstName = new TextField("Prénom", "John");
        TextField lastName = new TextField("Nom", "Doe");
        EmailField sender = new EmailField("Email", "john.doe@example.com");
        TextArea message = new TextArea(
            "Message",
            "Je vous contacte au sujet de ..."
        );
        message.setHeight("20em");

        FormLayout formLayout = new FormLayout();
        formLayout.setAutoResponsive(true);
        formLayout.setExpandFields(true);
        formLayout.setExpandColumns(true);

        formLayout.addFormRow(firstName, lastName, sender);

        var row2 = new FormRow();
        row2.add(message, 3);
        formLayout.add(row2);

        binder
            .forField(firstName)
            .asRequired()
            .bind(ContactForm::getFirstname, ContactForm::setFirstname);
        binder
            .forField(lastName)
            .asRequired()
            .bind(ContactForm::getLastname, ContactForm::setLastname);
        binder
            .forField(sender)
            .bind(ContactForm::getEmail, ContactForm::setEmail);
        binder
            .forField(message)
            .asRequired((value, context) ->
                value.isBlank()
                    ? ValidationResult.error("Veuillez ajouter un message")
                    : ValidationResult.ok()
            )
            .bind(ContactForm::getMessage, ContactForm::setMessage);

        var send = new Button("Envoyer", event -> {
            // mail from user to me
            SimpleMailMessage mailToMe = new SimpleMailMessage();
            mailToMe.setTo("antoine.haz@gmail.com");
            mailToMe.setCc(sender.getValue());
            mailToMe.setSubject(
                sender.getValue() +
                " - " +
                firstName.getValue() +
                " " +
                lastName.getValue()
            );
            mailToMe.setText(message.getValue());
            emails.send(mailToMe);

            Notification.show("Votre message a bien été envoyé !");
        });

        binder.addStatusChangeListener(event -> {
            send.setEnabled(!event.hasValidationErrors() && binder.isValid());
        });
        send.setEnabled(false);

        formLayout.addFormRow(send);

        add(new H1("Me contacter"));
        add(formLayout);
    }
}
