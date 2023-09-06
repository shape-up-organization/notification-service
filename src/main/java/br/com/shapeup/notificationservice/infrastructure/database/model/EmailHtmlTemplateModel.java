package br.com.shapeup.notificationservice.infrastructure.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name = "tb_email_html_template")
@Getter
@Setter
public class EmailHtmlTemplateModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    private String content;
    private String type;
    @CreatedDate
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Builder(toBuilder = true)
    public EmailHtmlTemplateModel() { }
}
