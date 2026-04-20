package com.giyong.logistics.domain.product.entity;

import com.giyong.logistics.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity @Getter
@Table(name = "product")
@Builder
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

    // 수정 메서드
    public void update (String productNumber, String productName, int price, ProductStatus status) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

}
