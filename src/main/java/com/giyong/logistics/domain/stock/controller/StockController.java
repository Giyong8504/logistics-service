package com.giyong.logistics.domain.stock.controller;

import com.giyong.logistics.domain.stock.dto.ReceiveRequest;
import com.giyong.logistics.domain.stock.dto.ReduceStockRequest;
import com.giyong.logistics.domain.stock.dto.RestockRequest;
import com.giyong.logistics.domain.stock.dto.ShipRequest;
import com.giyong.logistics.domain.stock.service.StockService;
import com.giyong.logistics.domain.stock.service.StockTxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;
    private final StockTxService stockTxService;

    // 재고 증가
    @PostMapping("/restock")
    public ResponseEntity<Void> restock(@RequestBody RestockRequest request) {
        stockTxService.restock(request.getProductId(), request.getQuantity());

        return ResponseEntity.ok().build();
    }

    // 재고 감소
    @PostMapping("/reduceStock")
    public ResponseEntity<Void> reduceStock(@RequestBody ReduceStockRequest request) {
        stockService.reduceStockRetry(request.getProductId(), request.getQuantity());

        return ResponseEntity.ok().build();
    }

    // 입고
    @PostMapping("/receive")
    public ResponseEntity<Void> receive(@RequestBody ReceiveRequest request) {

        stockService.receive(request.getProductId(), request.getQuantity());

        return ResponseEntity.ok().build();
    }

    // 출고
    @PostMapping("/ship")
    public ResponseEntity<Void> ship(@RequestBody ShipRequest request) {

        stockService.ship(request.getProductId(), request.getQuantity());

        return ResponseEntity.ok().build();
    }
}
