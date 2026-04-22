package com.giyong.logistics.domain.stock.dto;

import lombok.Getter;

@Getter
public class ReduceStockRequest {

    private Long productId;
    private int quantity;
}
