package com.harry.tradingapp.service;

import com.harry.tradingapp.model.Stock;

import java.util.List;

public interface StockService {
    Stock getStock(String symbol);
    List<Stock> getStockList();
    List<Stock> getMarketChart(String stockId, int days);
    Stock getStockDetails(String stockId);
    List<Stock> searchStock(String keyword);
    List<Stock> getTop50StocksByMarketCapRank();
    List<Stock> getTradingStocks();
}
