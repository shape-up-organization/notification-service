package br.com.shapeup.notificationservice.domain;

import java.time.LocalDateTime;

public record NotificationFriendshipRequest(
        String id,
        String usernameSender,
        String usernameReceiver,
        LocalDateTime createdAt
) {
}
