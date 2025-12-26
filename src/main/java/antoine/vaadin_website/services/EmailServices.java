package antoine.vaadin_website.services;

import antoine.vaadin_website.config.Ioc;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class EmailServices {

    @Getter
    @Builder
    public static class Args {

        private final String subject;
        private final String text;
        private final String from;
        private final String cc;
    }

    public static void send(Args args, boolean userTracking) {
        var emails = Ioc.getBean(JavaMailSender.class);

        SimpleMailMessage mailToMe = new SimpleMailMessage();
        mailToMe.setTo("antoine.haz@gmail.com");
        mailToMe.setFrom(args.getFrom());
        if (args.cc != null) mailToMe.setCc(args.getCc());
        mailToMe.setSubject(
            userTracking
                ? "portfolio-user-tracking : " + args.getSubject()
                : args.getSubject()
        );
        mailToMe.setText(args.getText());

        emails.send(mailToMe);

        log.info("Email sent to antoine.haz@gmail.com : {}", mailToMe);
    }
}
