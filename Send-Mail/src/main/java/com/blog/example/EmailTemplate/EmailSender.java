package com.blog.example.EmailTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@RestController
public class EmailSender {

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

    @PostMapping(value="/getdetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Details sendMail(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name",details.getName());
        model.put("age",details.getAge());
        model.put("country",details.getCountry());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("Test Mail");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }


}
