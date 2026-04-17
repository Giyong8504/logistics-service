package com.giyong.logistics.domain.product.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity @Getter
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "product_id", nullable = false)
    private Long productId;

    @Column (name = "product_number", nullable = false)
    private String productNumber;

    @Column (name = "product_name", nullable = false)
    private String productName;

    @Column (name = "price", nullable = false)
    private int price;

    @Enumerated(EnumType.STRING)
    @Column (name = "status", nullable = false)
    private ProductStatus status;
}
