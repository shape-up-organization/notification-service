package br.com.shapeup.notificationservice.message;

import java.time.LocalDateTime;

public record FriendshipRequestMessage(
        String id,
        String userSenderId,
        String userReceiverId,
        String usernameSender,
        String usernameReceiver,
        LocalDateTime createdAt
) {
}
