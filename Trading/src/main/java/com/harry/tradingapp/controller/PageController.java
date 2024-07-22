package com.harry.tradingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @GetMapping("/stock-detail")
    public String stockDetail() {
        return "stock-detail";
    }

    @GetMapping("/stock-list")
    public String stockList() {
        return "stock-list";
    }

    @GetMapping("/trading")
    public String trading() {
        return "trading";
    }

    @GetMapping("/transactions")
    public String transactions() {
        return "transactions";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

}
