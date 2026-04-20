package com.giyong.logistics.domain.product.dto;

import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.entity.ProductStatus;
import lombok.Getter;

@Getter
public class ProductRequest {

    private String productNumber;
    private String productName;
    private int price;
    private String status;

    public Product toEntity() {
        return Product.builder()
                .productNumber(productNumber)
                .productName(productName)
                .price(price)
                .status(ProductStatus.INACTIVE) // 저장 시 일단 비활성화
                .build();
    }
}
