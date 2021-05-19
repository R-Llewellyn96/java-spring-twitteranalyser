package com.springboot.javaspringtwitteranalyser.model;

import javax.persistence.*;

/**
 * Database Entry for a Tweet with Sentiment Score and UserID.
 *
 * @author Ryan Llewellyn
 */
@Entity
@Table(name = "tweetwsentimentdb")
public class TweetWSentimentDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long db_id;

    @Column(name = "user_id", nullable = false)
    public Long user_id;

    @Column(name = "tweet_id", nullable = false, unique = true)
    public Long tweet_id;

    @Column(name = "created_at", nullable = false)
    public String created_at;

    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "display_name", nullable = false)
    public String display_name;

    @Column(name = "tweet_text", nullable = false)
    public String tweet_text;

    @Column(name = "sentiment_score", nullable = false)
    public String sentiment_score;

    public TweetWSentimentDB(Long user_id, Long tweet_id, String created_at, String username, String display_name, String tweet_text, String sentiment_score) {
        this.user_id = user_id;
        this.tweet_id = tweet_id;
        this.created_at = created_at;
        this.username = username;
        this.display_name = display_name;
        this.tweet_text = tweet_text;
        this.sentiment_score = sentiment_score;
    }

    public TweetWSentimentDB() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDb_id() { return db_id; }
    public void setDb_id(Long db_id) { this.db_id = db_id; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "twitter_id")
    private User user;

    @Column(name = "user_id", nullable = false)
    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    @Column(name = "tweet_id", nullable = false)
    public Long getTweet_id() { return tweet_id; }
    public void setTweet_id(Long tweet_id) { this.tweet_id = tweet_id; }

    @Column(name = "created_at", nullable = false)
    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    @Column(name = "username", nullable = false)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name = "display_name", nullable = false)
    public String getDisplay_name() { return display_name; }
    public void setDisplay_name(String display_name) { this.display_name = display_name; }

    @Column(name = "tweet_text", nullable = false)
    public String getTweet_text() { return tweet_text; }
    public void setTweet_text(String tweet_text) { this.tweet_text = tweet_text; }

    @Column(name = "sentiment_score", nullable = false)
    public String getSentiment_score() { return sentiment_score; }
    public void setSentiment_score(String sentiment_score) { this.sentiment_score = sentiment_score; }
}