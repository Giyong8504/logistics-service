package com.giyong.logistics.domain.stock.service;

import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.repository.ProductRepository;
import com.giyong.logistics.domain.stock.entity.Stock;
import com.giyong.logistics.domain.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    // 재고 생성
    public void createStock(Product product) {
        Stock stock = new Stock(product,0); // 초기재고 0
        stockRepository.save(stock);
    }

    // 재고 증가
    @Transactional
    public void restock(Long productId, int quantity) {
        Stock stock = findStock(productId);
        stock.restock(quantity);
    }

    // 재고 감소
    @Transactional
    public void reduceStock(Long productId, int quantity) {
        Stock stock = findStock(productId);
        stock.reduceStock(quantity);
    }

    private Stock findStock(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));

        return stockRepository.findByProduct(product)
                .orElseThrow(() -> new IllegalArgumentException("재고가 없습니다."));

    }

}
