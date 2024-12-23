package com.green.email1.auth;

import com.green.email1.auth.model.AuthCodeDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public boolean sendCodeToEmail(String to, String subject, AuthCodeDto authCodeDto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        authCodeDto.setEmail(to);
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(getHtmlTemplate(authCodeDto), true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    private String getHtmlTemplate(AuthCodeDto authCodeDto) {
        return templateEngine.process("emailTemplate", getContext(authCodeDto));
    }

    private Context getContext(AuthCodeDto authCodeDto) {
        Map<String, Object> dto = new HashMap<>(2);
        dto.put("authCode", authCodeDto.getAuthCode());
        dto.put("maxDate", authCodeDto.getMaxDate());
        Context context = new Context();
        context.setVariables(dto);
        return context;
    }
}
