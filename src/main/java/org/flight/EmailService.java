package org.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendStatusUpdateEmail(String to, String flightId, String status) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Flight Status Update");
        message.setText("The status of flight " + flightId + " has been updated to " + status + ".");
        javaMailSender.send(message);
    }
}
