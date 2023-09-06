package br.com.shapeup.notificationservice.infrastructure.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_notification_history")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class NotificationHistoryModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(name = "notification_id")
    private String notificationId;
    private String type;
    @Column(name = "notification_sending_date")
    private LocalDateTime notificationSendingDate;

}
