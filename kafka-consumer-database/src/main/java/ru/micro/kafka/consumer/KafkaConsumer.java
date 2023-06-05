package ru.micro.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.micro.kafka.model.WikimediaData;
import ru.micro.kafka.repository.DataRepository;

@Service
public class KafkaConsumer {

    private DataRepository dataRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    public KafkaConsumer(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia", groupId = "myGroup")
    public void consumer(String eventMessage) {
        LOGGER.info(String.format("Message received -> %s",eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikimedia(eventMessage);

        dataRepository.save(wikimediaData);
    }

}
