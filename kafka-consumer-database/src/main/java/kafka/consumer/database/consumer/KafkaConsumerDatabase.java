package kafka.consumer.database.consumer;

import kafka.consumer.database.entity.WikimediaEntity;
import kafka.consumer.database.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    @Autowired
    private WikimediaRepository wikimediaRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Received event -> %s", eventMessage));
        WikimediaEntity entity = new WikimediaEntity();
        entity.setWikiEventData(eventMessage);
        wikimediaRepository.save(entity);
    }

}
