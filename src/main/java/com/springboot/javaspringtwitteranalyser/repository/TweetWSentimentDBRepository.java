package com.springboot.javaspringtwitteranalyser.repository;

import com.springboot.javaspringtwitteranalyser.model.TweetWSentimentDB;
import com.springboot.javaspringtwitteranalyser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository Interface for TweetWSentimentDB Entries
 */
@Repository
public interface TweetWSentimentDBRepository extends JpaRepository<TweetWSentimentDB, Long> {

    @Query("SELECT u FROM TweetWSentimentDB u WHERE u.tweet_id = ?1")
    Optional<TweetWSentimentDB> findTweetWSentimentDBByTweet_id(Long tweet_id);

    @Query("SELECT u FROM TweetWSentimentDB u WHERE u.user_id = ?1")
    List<TweetWSentimentDB> findAllByUser_id(Long user_id);
}
