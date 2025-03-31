package com.docker.demo;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendPlainTextEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRequest.getFrom());
        message.setTo(emailRequest.getTo());
        message.setCc(emailRequest.getCc());
        message.setBcc(emailRequest.getBcc());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());

        mailSender.send(message);
    }
}