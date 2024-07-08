package com.github.supercodingspringproject.repository.orders;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import com.github.supercodingspringproject.repository.generalUser.GeneralUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "g_user_id", nullable = false)
    private GeneralUser generalUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Sneaker model;

    @Column(name = "sneaker_size", nullable = false)
    private Integer sneakerSize;

    @Column(name = "order_quantity", nullable = false)
    private Integer orderQuantity;

    @Column(name = "shpping_address", nullable = false, length = 30)
    private String shppingAddress;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column(name = "order_at", nullable = false)
    private LocalDateTime orderAt;

}