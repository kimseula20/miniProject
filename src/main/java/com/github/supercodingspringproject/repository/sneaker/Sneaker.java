package com.github.supercodingspringproject.repository.sneaker;

import com.github.supercodingspringproject.repository.inventory.AbraodInventory;
import com.github.supercodingspringproject.repository.inventory.KoreaInventory;
import com.github.supercodingspringproject.repository.sneakerModelTraits.SneakerModelTrait;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sneaker")
public class Sneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", nullable = false)
    private Integer id;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "model")
    private Set<AbraodInventory> abraodInventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "model")
    private Set<KoreaInventory> koreaInventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
    private Set<SneakerModelTrait> sneakerModelTraits = new LinkedHashSet<>();

}