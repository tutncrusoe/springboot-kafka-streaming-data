package kafka.consumer.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wikimedia")
public class WikimediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
