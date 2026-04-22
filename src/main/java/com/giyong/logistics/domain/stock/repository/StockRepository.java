package com.giyong.logistics.domain.stock.repository;

import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByProduct(Product product);

}
