package ru.micro.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.micro.kafka.model.WikimediaData;

public interface DataRepository extends JpaRepository<WikimediaData,Long> {
}
