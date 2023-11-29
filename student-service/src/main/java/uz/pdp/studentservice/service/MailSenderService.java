package uz.pdp.studentservice.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uz.pdp.studentservice.exception.SendVerificationCodeException;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendVerificationCode(String email) {
        Random random = new Random();
        String verificationCode = String.valueOf(random.nextInt(90000) + 10000);
        try {
            String message = "This is your verification code: " + verificationCode;
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
            return message;
        } catch (Exception e) {
            throw new SendVerificationCodeException("Error to send the verification code");
        }

    }

}