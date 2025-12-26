package antoine.vaadin_website.components.pages.contactme;

import antoine.vaadin_website.services.EmailServices;
import antoine.vaadin_website.services.EmailServices.Args;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormRow;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public class ContactForm
    extends Composite<FormLayout>
    implements LocaleChangeObserver {

    @Data
    private static class ContactFormInfo {

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

    TextField firstname = new TextField();
    TextField lastname = new TextField();
    TextField email = new TextField();
    TextArea message = new TextArea();

    @Override
    protected FormLayout initContent() {
        BeanValidationBinder<ContactFormInfo> binder =
            new BeanValidationBinder<>(ContactFormInfo.class);
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
            try {
                EmailServices.send(
                    Args.builder()
                        .subject(
                            "%s - %s %s".formatted(
                                    email.getValue(),
                                    firstname.getValue(),
                                    lastname.getValue()
                                )
                        )
                        .cc(email.getValue())
                        .text(message.getValue())
                        .build(),
                    false
                );

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

        return formLayout;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        firstname.setLabel(getTranslation("contact.form.labels.firstname"));
        firstname.setPlaceholder(
            getTranslation("contact.form.placeholders.firstname")
        );

        lastname.setLabel(getTranslation("contact.form.labels.lastname"));
        lastname.setPlaceholder(
            getTranslation("contact.form.placeholders.lastname")
        );

        email.setLabel(getTranslation("contact.form.labels.email"));
        email.setPlaceholder(getTranslation("contact.form.placeholders.email"));

        message.setLabel(getTranslation("contact.form.labels.message"));
        message.setPlaceholder(
            getTranslation("contact.form.placeholders.message")
        );
    }
}
