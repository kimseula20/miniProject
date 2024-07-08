package com.github.supercodingspringproject.repository.inventory;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "abraod_inventory")
public class AbraodInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "abroad_inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Sneaker model;

    @Column(name = "sneaker_size")
    private Integer sneakerSize;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "expected_delivered_day")
    private Integer expectedDeliveredDay;

}