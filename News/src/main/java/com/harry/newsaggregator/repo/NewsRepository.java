package com.harry.newsaggregator.repo;

import com.harry.newsaggregator.model.NewsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsItem, Long> {
}
