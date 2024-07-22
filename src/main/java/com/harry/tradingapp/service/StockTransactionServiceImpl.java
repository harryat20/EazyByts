package com.harry.tradingapp.service;

import com.harry.tradingapp.model.StockTransaction;
import com.harry.tradingapp.model.TransactionType;
import com.harry.tradingapp.repo.StockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class StockTransactionServiceImpl implements StockTransactionService {

    @Autowired
    private StockTransactionRepository stockTransactionRepository;

    @Override
    public StockTransaction buyStock(Long userId, String stockSymbol, Integer quantity, BigDecimal pricePerUnit) {
        return createTransaction(userId, stockSymbol, TransactionType.BUY, quantity, pricePerUnit);
    }

    @Override
    public StockTransaction sellStock(Long userId, String stockSymbol, Integer quantity, BigDecimal pricePerUnit) {
        return createTransaction(userId, stockSymbol, TransactionType.SELL, quantity, pricePerUnit);
    }

    private StockTransaction createTransaction(Long userId, String stockSymbol, TransactionType transactionType, Integer quantity, BigDecimal pricePerUnit) {
        StockTransaction transaction = new StockTransaction();
        transaction.setUserId(userId);
        transaction.setStockSymbol(stockSymbol);
        transaction.setTransactionType(transactionType);
        transaction.setQuantity(quantity);
        transaction.setPricePerUnit(pricePerUnit);
        transaction.setTransactionDate(LocalDateTime.now());
        return stockTransactionRepository.save(transaction);
    }
}