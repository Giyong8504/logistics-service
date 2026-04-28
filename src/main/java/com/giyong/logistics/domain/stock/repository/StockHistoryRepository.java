package com.giyong.logistics.domain.stock.repository;

import com.giyong.logistics.domain.stock.entity.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {

}
