package antoine.vaadin_website.services;

import antoine.vaadin_website.config.Ioc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class EmailServices {

    private static final ExecutorService executor =
        Executors.newSingleThreadExecutor();

    @Getter
    @Builder
    public static class Args {

        private final String subject;
        private final String text;
        private final String cc;
    }

    public static void send(Args args, boolean userTracking) {
        SimpleMailMessage mailToMe = new SimpleMailMessage();
        mailToMe.setTo("antoine.haz@gmail.com");
        mailToMe.setFrom("antoine.haz@gmail.com");
        if (args.cc != null) mailToMe.setCc(args.getCc());
        mailToMe.setSubject(
            userTracking
                ? "portfolio-user-tracking : " + args.getSubject()
                : args.getSubject()
        );
        mailToMe.setText(args.getText());

        Runnable sendEmail = () -> {
            var emails = Ioc.getBean(JavaMailSender.class);

            emails.send(mailToMe);
            log.info("Email sent to antoine.haz@gmail.com : {}", mailToMe);
        };

        if (userTracking) {
            executor.submit(() -> {
                try {
                    sendEmail.run();
                } catch (Exception e) {
                    log.error(
                        "Failed to send email asynchronously: {}",
                        args,
                        e
                    );
                }
            });
        } else {
            sendEmail.run();
        }
    }

    public static void sendAsync(Args args, boolean userTracking) {}
}
