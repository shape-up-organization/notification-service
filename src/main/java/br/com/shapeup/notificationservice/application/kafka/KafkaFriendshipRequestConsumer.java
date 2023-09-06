package br.com.shapeup.notificationservice.application.kafka;

import br.com.shapeup.notificationservice.config.serdes.GsonBuilderSingletonEnum;
import br.com.shapeup.notificationservice.domain.NotificationFriendshipRequest;
import br.com.shapeup.notificationservice.infrastructure.database.model.NotificationHistoryModel;
import br.com.shapeup.notificationservice.infrastructure.database.repository.NotificationHistoryRepository;
import br.com.shapeup.notificationservice.infrastructure.websocket.WebSocketNotificationService;
import br.com.shapeup.notificationservice.message.FriendshipRequestMessage;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaFriendshipRequestConsumer {

    private final WebSocketNotificationService webSocketAdapter;
    private final NotificationHistoryRepository notificationHistoryRepository;

    @KafkaListener(topics = "tp-friendship-request", groupId = "gp-friendship-request")
    private void consume(String message) {
        log.info("FriendshipRequestConsumer.consume");

        var gson = GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder();

        FriendshipRequestMessage messageJson = gson.fromJson(message, FriendshipRequestMessage.class);

        var notification = new NotificationFriendshipRequest(
                messageJson.id(),
                messageJson.usernameSender(),
                messageJson.usernameReceiver(),
                LocalDateTime.now()
        );

        webSocketAdapter.sendNotification(messageJson.userReceiverId(), convertNotificationToJson(notification));
        var notificationHistoryModel = NotificationHistoryModel.builder()
                .type("FRIENDSHIP_REQUEST")
                .notificationSendingDate(LocalDateTime.now())
                .build();

        notificationHistoryRepository.save(notificationHistoryModel);
    }

    private String convertNotificationToJson(NotificationFriendshipRequest notification) {
        return GsonBuilderSingletonEnum.INSTANCE.getGsonBuilder().toJson(notification);
    }
}
