package com.github.supercodingspringproject.repository.inventory;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "korea_inventory")
public class KoreaInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korea_inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Sneaker model;

    @Column(name = "sneaker_size")
    private Integer sneakerSize;

    @Column(name = "stock")
    private Integer stock;

}