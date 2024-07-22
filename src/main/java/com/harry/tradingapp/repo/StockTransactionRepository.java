package com.harry.tradingapp.repo;

import com.harry.tradingapp.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
}