package br.com.shapeup.notificationservice.message;

import java.time.LocalDateTime;

public record SendCodeVerificationMessage(
        String id,
        String email,
        String code,
        String userName,
        LocalDateTime createdAt
) {
}
