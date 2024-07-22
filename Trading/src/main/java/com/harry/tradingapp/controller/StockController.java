package com.harry.tradingapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harry.tradingapp.model.Stock;
import com.harry.tradingapp.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;
    private final ObjectMapper objectMapper;

    public StockController(StockService stockService, ObjectMapper objectMapper) {
        this.stockService = stockService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/getStock")
    public ResponseEntity<JsonNode> getStock(@RequestParam String symbol) {
        Stock stockResponse = stockService.getStock(symbol);
        JsonNode jsonNode = objectMapper.valueToTree(stockResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/getStockList")
    public ResponseEntity<JsonNode> getStockList() {
        List<Stock> stockListResponse = stockService.getStockList();
        JsonNode jsonNode = objectMapper.valueToTree(stockListResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/getMarketChart")
    public ResponseEntity<JsonNode> getMarketChart(@RequestParam String stockId, @RequestParam int days) {
        List<Stock> marketChartResponse = stockService.getMarketChart(stockId, days);
        JsonNode jsonNode = objectMapper.valueToTree(marketChartResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/getStockDetails")
    public ResponseEntity<JsonNode> getStockDetails(@RequestParam String stockId) {
        Stock stockDetailsResponse = stockService.getStockDetails(stockId);
        JsonNode jsonNode = objectMapper.valueToTree(stockDetailsResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/searchStock")
    public ResponseEntity<JsonNode> searchStock(@RequestParam String keyword) {
        List<Stock> stockSearchResponse = stockService.searchStock(keyword);
        JsonNode jsonNode = objectMapper.valueToTree(stockSearchResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/getTop50StocksByMarketCapRank")
    public ResponseEntity<JsonNode> getTop50StocksByMarketCapRank() {
        List<Stock> top50StocksResponse = stockService.getTop50StocksByMarketCapRank();
        JsonNode jsonNode = objectMapper.valueToTree(top50StocksResponse);
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/getTradingStocks")
    public ResponseEntity<JsonNode> getTradingStocks() {
        List<Stock> tradingStocksResponse = stockService.getTradingStocks();
        JsonNode jsonNode = objectMapper.valueToTree(tradingStocksResponse);
        return ResponseEntity.ok(jsonNode);
    }
}
