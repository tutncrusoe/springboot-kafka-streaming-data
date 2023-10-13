package kafka.producer.wikimedia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String kafkaTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(kafkaTopic).build();
    }


}
