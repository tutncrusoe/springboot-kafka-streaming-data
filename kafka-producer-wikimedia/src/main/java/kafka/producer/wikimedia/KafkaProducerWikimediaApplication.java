package kafka.producer.wikimedia;

import kafka.producer.wikimedia.producer.KafkaProducerStreaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    @Autowired
    private KafkaProducerStreaming kafkaProducerStreaming;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        kafkaProducerStreaming.sendMessage();
    }
}
