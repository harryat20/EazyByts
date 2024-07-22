package com.harry.tradingapp.model;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String stockSymbol;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Integer quantity;

    private BigDecimal pricePerUnit;

    private LocalDateTime transactionDate;

}

