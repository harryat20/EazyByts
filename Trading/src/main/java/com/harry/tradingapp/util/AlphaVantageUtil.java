package com.harry.tradingapp.util;

import com.harry.tradingapp.model.Stock;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class AlphaVantageUtil {

    private static final String API_KEY = "your_alpha_vantage_api_key";
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=" + API_KEY;

    public static Stock fetchStockData(String symbol) {
        String function = "TIME_SERIES_INTRADAY";
        String interval = "1min";
        String url = String.format(BASE_URL, function, symbol) + "&interval=" + interval;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        JSONObject timeSeries = json.getJSONObject("Time Series (1min)");
        String latestTimestamp = timeSeries.keys().next();
        JSONObject latestData = timeSeries.getJSONObject(latestTimestamp);

        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setPrice(latestData.getDouble("1. open"));
        stock.setTimestamp(latestTimestamp);

        return stock;
    }

    public static List<Stock> fetchStockList() {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(fetchStockData("AAPL"));
        stockList.add(fetchStockData("TSLA"));
        return stockList;
    }

    public static List<Stock> fetchMarketChart(String stockId, int days) {
        String function = "TIME_SERIES_DAILY";
        String url = String.format(BASE_URL, function, stockId);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        JSONObject timeSeries = json.getJSONObject("Time Series (Daily)");
        List<Stock> stockList = new ArrayList<>();

        int count = 0;
        for (String date : timeSeries.keySet()) {
            if (count >= days) break;
            JSONObject dailyData = timeSeries.getJSONObject(date);

            Stock stock = new Stock();
            stock.setSymbol(stockId);
            stock.setPrice(dailyData.getDouble("1. open"));
            stock.setTimestamp(date);

            stockList.add(stock);
            count++;
        }

        return stockList;
    }

    public static Stock fetchStockDetails(String stockId) {
        return fetchStockData(stockId);
    }

    public static List<Stock> searchStock(String keyword) {
        String function = "SYMBOL_SEARCH";
        String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + keyword + "&apikey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        JSONArray matches = json.getJSONArray("bestMatches");
        List<Stock> stockList = new ArrayList<>();

        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);

            Stock stock = new Stock();
            stock.setSymbol(match.getString("1. symbol"));
            stock.setPrice(match.getDouble("9. matchScore"));
            stockList.add(stock);
        }

        return stockList;
    }

    public static List<Stock> fetchTop50StocksByMarketCapRank() {
        // Note: Alpha Vantage does not directly provide an endpoint for top 50 stocks by market cap.
        // This is a mock implementation. You need to replace this with a real API that provides this data.
        List<Stock> stockList = new ArrayList<>();
        stockList.add(fetchStockData("AAPL"));
        stockList.add(fetchStockData("MSFT"));
        // Add more stocks as needed
        return stockList;
    }

    public static List<Stock> fetchTradingStocks() {
        // Note: Alpha Vantage does not directly provide an endpoint for trading stocks.
        // This is a mock implementation. You need to replace this with a real API that provides this data.
        List<Stock> stockList = new ArrayList<>();
        stockList.add(fetchStockData("AAPL"));
        stockList.add(fetchStockData("TSLA"));
        // Add more stocks as needed
        return stockList;
    }
}
