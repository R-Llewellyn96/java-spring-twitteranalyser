package com.springboot.javaspringtwitteranalyser.repository;

import com.springboot.javaspringtwitteranalyser.model.TweetWSentimentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for TweetWSentimentDB Entries
 */
@Repository
public interface TweetWSentimentDBRepository extends JpaRepository<TweetWSentimentDB, Long> {
}
