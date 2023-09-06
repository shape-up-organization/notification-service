package br.com.shapeup.notificationservice.infrastructure.database.repository;

import br.com.shapeup.notificationservice.infrastructure.database.model.EmailHtmlTemplateModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailHtmlTemplateModel, UUID> {

    Optional<EmailHtmlTemplateModel> findByType(String type);
}
