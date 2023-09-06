package br.com.shapeup.notificationservice.message;

import java.time.OffsetDateTime;

public record SendCodeVerificationMessage(
        String id,
        String email,
        String code,
        String userName,
        OffsetDateTime createdAt
) {
}
