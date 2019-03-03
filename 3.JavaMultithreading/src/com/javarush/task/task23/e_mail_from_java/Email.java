package com.javarush.task.task23.e_mail_from_java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Email {
    public static void main(String[] args) {
        Properties props = new Properties();
        // Данные при отправлении через gmail
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pivovanna@gmail.com", "0okmnji9");
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("pivovanna@gmail.com"));
            InternetAddress[] addresses = {new InternetAddress("pivikua@gmail.com")};
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject("Тестовое письмо из Джава");
            message.setSentDate(new Date());
            message.setText("Вот такое ссобщение я могу послать из Джава.");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
