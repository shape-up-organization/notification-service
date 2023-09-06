package br.com.shapeup.notificationservice.infrastructure.database.repository;

import br.com.shapeup.notificationservice.infrastructure.database.model.NotificationHistoryModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationHistoryRepository extends JpaRepository<NotificationHistoryModel, UUID> {
}
