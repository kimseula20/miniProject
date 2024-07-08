package com.github.supercodingspringproject.repository.sneakerModelTraits;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sneaker_traits")
public class SneakerTrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trait_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "descriptions")
    private String descriptions;

    @Lob
    @Column(name = "english_desc")
    private String englishDesc;

}