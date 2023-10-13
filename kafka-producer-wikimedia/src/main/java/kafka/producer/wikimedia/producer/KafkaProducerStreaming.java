package kafka.producer.wikimedia.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import kafka.producer.wikimedia.handler.WikiMediaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducerStreaming {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerStreaming.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String kafkaTopic;

    @Value("${url.streaming.data}")
    private String urlStreaming;

    public void sendMessage() throws InterruptedException {
        EventHandler eventHandler = new WikiMediaHandler(kafkaTemplate, kafkaTopic);

        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(urlStreaming)).build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
