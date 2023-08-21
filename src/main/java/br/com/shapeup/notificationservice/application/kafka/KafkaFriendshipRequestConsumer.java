package br.com.shapeup.notificationservice.application.kafka;

import br.com.shapeup.notificationservice.config.serdes.GsonBuilderSingletonEnum;
import br.com.shapeup.notificationservice.domain.NotificationFriendshipRequest;
import br.com.shapeup.notificationservice.infrastructure.websocket.WebSocketNotificationService;
import br.com.shapeup.notificationservice.message.FriendshipRequestMessage;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaFriendshipRequestConsumer {

    private final WebSocketNotificationService webSocketAdapter;

    @KafkaListener(topics = "tp-friendship-request", groupId = "gp-friendship-request")
    private void consume(String message) {
        System.out.println("FriendshipRequestConsumer.consume");

        var gson = GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder();

        FriendshipRequestMessage messageJson = gson.fromJson(message, FriendshipRequestMessage.class);

        var notification = new NotificationFriendshipRequest(
                messageJson.usernameSender(),
                messageJson.usernameReceiver(),
                LocalDateTime.now()
        );

        webSocketAdapter.sendNotification(messageJson.userReceiverId(), convertNotificationToJson(notification));
    }

    private String convertNotificationToJson(NotificationFriendshipRequest notification) {
        return GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder().toJson(notification);
    }
}
