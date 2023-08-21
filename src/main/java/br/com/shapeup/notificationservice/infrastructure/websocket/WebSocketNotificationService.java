package br.com.shapeup.notificationservice.infrastructure.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketNotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendNotification(String username, String content) {
        messagingTemplate.convertAndSendToUser(
            username,
            "/user-notification/notifications",
            content
        );
    }
}
