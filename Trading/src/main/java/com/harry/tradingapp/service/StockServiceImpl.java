package com.harry.tradingapp.service;

import com.harry.tradingapp.model.Stock;
import com.harry.tradingapp.util.AlphaVantageUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public Stock getStock(String symbol) {
        return AlphaVantageUtil.fetchStockData(symbol);
    }

    @Override
    public List<Stock> getStockList() {
        return AlphaVantageUtil.fetchStockList();
    }

    @Override
    public List<Stock> getMarketChart(String stockId, int days) {
        return AlphaVantageUtil.fetchMarketChart(stockId, days);
    }

    @Override
    public Stock getStockDetails(String stockId) {
        return AlphaVantageUtil.fetchStockDetails(stockId);
    }

    @Override
    public List<Stock> searchStock(String keyword) {
        return AlphaVantageUtil.searchStock(keyword);
    }

    @Override
    public List<Stock> getTop50StocksByMarketCapRank() {
        return AlphaVantageUtil.fetchTop50StocksByMarketCapRank();
    }

    @Override
    public List<Stock> getTradingStocks() {
        return AlphaVantageUtil.fetchTradingStocks();
    }
}
