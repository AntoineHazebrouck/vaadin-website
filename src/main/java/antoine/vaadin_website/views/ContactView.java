package antoine.vaadin_website.views;

import antoine.vaadin_website.components.Page;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormRow;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Route("contact")
@PageTitle("Contact")
public class ContactView extends Page {

    @Data
    private static class ContactForm {

        @NotEmpty
        @NotBlank
        private String firstname;

        @NotEmpty
        @NotBlank
        private String lastname;

        @NotEmpty
        @Email
        private String email;

        @NotEmpty
        @NotBlank
        private String message;
    }

    private final TextField firstname = new TextField("Prénom", "John");
    private final TextField lastname = new TextField("Nom", "Doe");
    private final TextField email = new TextField(
        "Email",
        "john.doe@example.com"
    );
    private final TextArea message = new TextArea(
        "Message",
        "Je vous contacte au sujet de ..."
    );

    public ContactView(JavaMailSender emails) {
        BeanValidationBinder<ContactForm> binder = new BeanValidationBinder<>(
            ContactForm.class
        );
        binder.bindInstanceFields(this);

        message.setHeight("20em");

        FormLayout formLayout = new FormLayout();
        formLayout.setAutoResponsive(true);
        formLayout.setExpandFields(true);
        formLayout.setExpandColumns(true);

        formLayout.addFormRow(firstname, lastname, email);

        var row2 = new FormRow();
        row2.add(message, 3);
        formLayout.add(row2);

        var send = new Button("Envoyer", event -> {
            // mail from user to me
            SimpleMailMessage mailToMe = new SimpleMailMessage();
            mailToMe.setTo("antoine.haz@gmail.com");
            mailToMe.setCc(email.getValue());
            mailToMe.setSubject(
                email.getValue() +
                " - " +
                firstname.getValue() +
                " " +
                lastname.getValue()
            );
            mailToMe.setText(message.getValue());

            try {
                emails.send(mailToMe);

                Notification.show("Votre message a bien été envoyé !");
            } catch (Exception e) {
                Notification.show(
                    "Erreur lors de l'envoi du message ! Veuillez réessayer ou me contacter par email."
                );
            }
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
