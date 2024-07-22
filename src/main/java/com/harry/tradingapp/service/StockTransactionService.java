package com.harry.tradingapp.service;

import com.harry.tradingapp.model.StockTransaction;

import java.math.BigDecimal;

public interface StockTransactionService {
    StockTransaction buyStock(Long userId, String stockSymbol, Integer quantity, BigDecimal pricePerUnit);
    StockTransaction sellStock(Long userId, String stockSymbol, Integer quantity, BigDecimal pricePerUnit);
}