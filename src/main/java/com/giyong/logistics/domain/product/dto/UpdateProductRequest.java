package com.giyong.logistics.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    private String productNumber;
    private String productName;
    private int price;
    private String status;

}
