package com.giyong.logistics.domain.product.dto;

import com.giyong.logistics.common.entity.BaseEntity;
import com.giyong.logistics.domain.product.entity.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponse {

    private Long productId;
    private String productNumber;
    private String productName;
    private int price;
    private String status;
    private BaseEntity reg_dt;
    private BaseEntity mod_dt;

    public ProductResponse(Product product) {
        this.productId = product.getProductId();
        this.productNumber = product.getProductNumber();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.status = product.getStatus().name();
        this.reg_dt = product;
        this.mod_dt = product;
    }
}
