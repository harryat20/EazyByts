package com.harry.newsaggregator.service;

import com.harry.newsaggregator.model.NewsItem;
import com.harry.newsaggregator.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsItem> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<NewsItem> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public NewsItem saveNews(NewsItem newsItem) {
        return newsRepository.save(newsItem);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
