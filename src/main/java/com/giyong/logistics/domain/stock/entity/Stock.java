package com.giyong.logistics.domain.stock.entity;

import com.giyong.logistics.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    @Column (name = "stock_id", nullable = false)
    private Long stockId;

    @OneToOne(fetch = FetchType.LAZY) // 1:1 연결
    @JoinColumn (name = "product_id", nullable = false) // productId와 연결 FK
    private Product product; // product 객체 자체.

    @Column (name = "quantity", nullable = false)
    private int quantity;

}
