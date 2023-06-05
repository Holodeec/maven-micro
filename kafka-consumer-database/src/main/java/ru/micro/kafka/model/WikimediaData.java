package ru.micro.kafka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recent")
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikimedia;
}
