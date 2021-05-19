package com.springboot.javaspringtwitteranalyser.model;

import javax.persistence.*;

/**
 * Database Entry for a User containing only UserID,
 * which is used as a foreign key in TweetWSentimentDB Table.
 *
 * @author Ryan Llewellyn
 */
@Entity
@Table(name = "usertb")
public class User {

    @Id
    @Column(name = "twitter_id")
    public Long twitter_id;

    public User(Long twitter_id) {
        this.twitter_id = twitter_id;
    }

    public User() { }

    @OneToOne(mappedBy = "TweetWSentimentDB")
    private TweetWSentimentDB tweetWSentimentDB;

    @Id
    @Column(name = "twitter_id", nullable = false)
    public Long getTwitter_id() { return twitter_id; }
    public void setTwitter_id(Long twitter_id) { this.twitter_id = twitter_id; }
}
