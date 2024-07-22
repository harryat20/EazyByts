package com.harry.tradingapp.model;


import lombok.Data;

@Data
public class Stock {
    private String symbol;
    private double price;
    private String timestamp;

}
