package br.com.shapeup.notificationservice.application.kafka;

import br.com.shapeup.notificationservice.config.serdes.GsonBuilderSingletonEnum;
import br.com.shapeup.notificationservice.domain.enums.HtmlTemplateType;
import br.com.shapeup.notificationservice.infrastructure.email.EmailService;
import br.com.shapeup.notificationservice.infrastructure.database.repository.EmailTemplateRepository;
import br.com.shapeup.notificationservice.message.SendCodeVerificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaCodeVerificationConsumer {

    private final EmailService emailService;
    private final EmailTemplateRepository emailTemplateRepository;

    @KafkaListener(topics = "tp-send-email-code-verification", groupId = "gp-send-email-code-verification")
    public void consumeEmail(String message) {
        log.info("KafkaEmailCodeVerificationConsumer.consume");

        var gson = GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder();
        SendCodeVerificationMessage messageJson = gson.fromJson(message, SendCodeVerificationMessage.class);

        var template = emailTemplateRepository.findByType(HtmlTemplateType.CONFIRM_EMAIL_CODE_VERIFICATION.getValue())
                .orElseThrow()
                .getContent();

        template = template.replace("{{code}}", messageJson.code());
        template = template.replace("{{email}}", messageJson.email());
        template = template.replace("{{userName}}", messageJson.userName());

        emailService.sendHtmlEmail(messageJson.email(), "Shape Up - Código de verificação", template);
    }

    @KafkaListener(topics = "tp-send-reset-password-code-verification", groupId = "gp-send-reset-password-code-verification")
    public void consumeResetPassword(String message) {
        log.info("KafkaResetPasswordCodeVerificationConsumer.consume");

        var gson = GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder();
        SendCodeVerificationMessage messageJson = gson.fromJson(message, SendCodeVerificationMessage.class);

        var template = emailTemplateRepository.findByType(HtmlTemplateType.RESET_PASSWORD_CODE_VERIFICATION.getValue())
                .orElseThrow()
                .getContent();

        template = template.replace("{{code}}", messageJson.code());
        template = template.replace("{{email}}", messageJson.email());
        template = template.replace("{{userName}}", messageJson.userName());

        emailService.sendHtmlEmail(messageJson.email(), "Shape Up - Código de verificação", template);
    }
}
