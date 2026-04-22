package com.giyong.logistics.domain.stock.dto;

import lombok.Getter;

@Getter
public class RestockRequest {
    private Long productId;
    private int quantity;
}
