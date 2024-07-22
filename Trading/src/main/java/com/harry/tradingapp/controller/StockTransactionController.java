package com.harry.tradingapp.controller;

import com.harry.tradingapp.model.StockTransaction;
import com.harry.tradingapp.repo.StockTransactionRepository;
import com.harry.tradingapp.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
public class StockTransactionController {

    @Autowired
    private StockTransactionService stockTransactionService;

    @Autowired
    private StockTransactionRepository stockTransactionRepository;


    @PostMapping("/buy")
    public ResponseEntity<StockTransaction> buyStock(
            @RequestHeader("userId") Long userId,
            @RequestHeader("stockSymbol") String stockSymbol,
            @RequestHeader("quantity") Integer quantity,
            @RequestHeader("pricePerUnit") BigDecimal pricePerUnit) {
        StockTransaction transaction = stockTransactionService.buyStock(userId, stockSymbol, quantity, pricePerUnit);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/sell")
    public ResponseEntity<StockTransaction> sellStock(
            @RequestHeader("userId") Long userId,
            @RequestHeader("stockSymbol") String stockSymbol,
            @RequestHeader("quantity") Integer quantity,
            @RequestHeader("pricePerUnit") BigDecimal pricePerUnit) {
        StockTransaction transaction = stockTransactionService.sellStock(userId, stockSymbol, quantity, pricePerUnit);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockTransaction> getTransactionById(@PathVariable Long id) {
        return stockTransactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
