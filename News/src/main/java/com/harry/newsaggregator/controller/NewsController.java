package com.harry.newsaggregator.controller;

import com.harry.newsaggregator.model.NewsItem;
import com.harry.newsaggregator.service.NewsService;
import com.harry.newsaggregator.service.RssFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private RssFeedService rssFeedService;

    @GetMapping
    public String getAllNews(Model model) {
        List<NewsItem> newsItems = newsService.getAllNews();
        model.addAttribute("newsItems", newsItems);
        return "news";
    }

    @GetMapping("/{id}")
    public String getNewsById(@PathVariable Long id, Model model) {
        Optional<NewsItem> newsItem = newsService.getNewsById(id);
        newsItem.ifPresent(item -> model.addAttribute("newsItem", item));
        return "news";
    }

    @PostMapping
    public String saveNews(@RequestBody NewsItem newsItem) {
        newsService.saveNews(newsItem);
        return "redirect:/news";
    }

    @DeleteMapping("/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return "redirect:/news";
    }

    @GetMapping("/fetch")
    public String fetchRssFeed(@RequestParam String url, Model model) throws Exception {
        List<NewsItem> newsItems = rssFeedService.fetchRssFeed(url);
        model.addAttribute("newsItems", newsItems);
        return "news";
    }
}
