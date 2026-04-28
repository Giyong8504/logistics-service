package com.giyong.logistics.domain.stock.service;

import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.repository.ProductRepository;
import com.giyong.logistics.domain.stock.entity.Stock;
import com.giyong.logistics.domain.stock.entity.StockHistory;
import com.giyong.logistics.domain.stock.entity.StockType;
import com.giyong.logistics.domain.stock.repository.StockHistoryRepository;
import com.giyong.logistics.domain.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final StockTxService stockTxService;
    private final StockHistoryRepository stockHistoryRepository;
    private final ProductRepository productRepository;


    // 재고 생성
    public void createStock(Product product) {
        Stock stock = new Stock(product,0); // 초기재고 0
        stockRepository.save(stock);
    }

//    // 재고 증가
//    @Transactional
//    public void restock(Long productId, int quantity) {
//        Stock stock = findStock(productId);
//        stock.restock(quantity);
//    }

//    // 재고 감소
//    @Transactional
//    public void reduceStock(Long productId, int quantity) {
//        Stock stock = findStock(productId);
//        stock.reduceStock(quantity);
//    }

    // 동시성 재시도
    public void reduceStockRetry(Long productId, int quantity) {

        int retry = 0;

        while (retry < 3) {
            try {
                stockTxService.reduceStock(productId, quantity);
                return;
            } catch (ObjectOptimisticLockingFailureException e) {
                retry++;
                System.out.println("동시성 충돌 발생. 재시도 " + retry);
            }
        }

        throw new IllegalStateException("재고 처리 실패 충돌 재시도 3회)");
    }

//    private Stock findStock(Long productId) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
//
//        return stockRepository.findByProduct(product)
//                .orElseThrow(() -> new IllegalArgumentException("재고가 없습니다."));
//
//    }

    // 입고
    public void receive(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));

        // 재고 증가
        stockTxService.restock(productId, quantity);

        // 이력 내용 저장
        StockHistory history = new StockHistory(
                null,
                product,
                quantity,
                StockType.IN
        );

        stockHistoryRepository.save(history);
    }

    // 출고
    public void ship(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다"));

        // 재고 감소
        stockTxService.reduceStock(productId, quantity);

        // 이력 내용 저장
        StockHistory history = new StockHistory(
                null,
                product,
                quantity,
                StockType.IN
        );

        stockHistoryRepository.save(history);
    }

}
