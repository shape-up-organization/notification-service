package br.com.shapeup.notificationservice.config.kafka;

import br.com.shapeup.notificationservice.infrastructure.kafka.Topic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
public class TopicConfig {

    @Bean
    public NewTopic friendshipRequestNotificationFactory() {
        return TopicBuilder
                .name(Topic.FRIENDSHIP_REQUEST.getName())
                .partitions(1)
                .compact()
                .build();
    }
}
