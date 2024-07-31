package com.harry.newsaggregator.service;

import com.harry.newsaggregator.model.NewsItem;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RssFeedService {

    public List<NewsItem> fetchRssFeed(String feedUrl) throws Exception {
        URL url = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));
        List<NewsItem> newsItems = new ArrayList<>();

        for (SyndEntry entry : feed.getEntries()) {
            NewsItem newsItem = new NewsItem();
            newsItem.setTitle(entry.getTitle());
            newsItem.setLink(entry.getLink());
            newsItem.setDescription(entry.getDescription().getValue());
            newsItems.add(newsItem);
        }

        return newsItems;
    }
}
