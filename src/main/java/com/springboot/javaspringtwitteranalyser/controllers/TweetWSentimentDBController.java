package com.springboot.javaspringtwitteranalyser.controllers;

import com.springboot.javaspringtwitteranalyser.exception.ResourceNotFoundException;
import com.springboot.javaspringtwitteranalyser.model.TweetWSentimentDB;
import com.springboot.javaspringtwitteranalyser.repository.TweetWSentimentDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TweetWSentimentDBController {

    @Autowired
    private TweetWSentimentDBRepository tweetWSentimentDBRepository;

    @GetMapping("/tweets")
    public List<TweetWSentimentDB> getAllTweets() { return tweetWSentimentDBRepository.findAll(); }

    @GetMapping("/tweets/{id}")
    public ResponseEntity<TweetWSentimentDB> getTweetById(@PathVariable(value = "id") Long tweet_id)
            throws ResourceNotFoundException {
        TweetWSentimentDB tweet = tweetWSentimentDBRepository.findTweetWSentimentDBByTweet_id(tweet_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tweet not found for this id :: " + tweet_id));
        return ResponseEntity.ok().body(tweet);
    }

    @GetMapping("/tweets/user/{id}")
    public List<TweetWSentimentDB> getTweetsByUserId(@PathVariable(value = "id") Long user_id)
            throws ResourceNotFoundException {
        try {
            List<TweetWSentimentDB> tweetList = tweetWSentimentDBRepository.findAllByUser_id(user_id);
            if (!tweetList.isEmpty()) {
            return tweetList;
            } else {
                throw new ResourceNotFoundException("Tweets not found for this id :: " + user_id);
            }
        }catch (Exception e) {
            throw new ResourceNotFoundException("Tweets not found for this id :: " + user_id);
        }
    }

    @PostMapping("/tweets")
    public TweetWSentimentDB createTweet(@Valid @RequestBody TweetWSentimentDB tweet) {
        return tweetWSentimentDBRepository.save(tweet);
    }

    @PutMapping("/tweets/edit/{id}")
    public ResponseEntity<TweetWSentimentDB> updateTweet(@PathVariable(value = "id") Long tweet_id,
                                           @Valid @RequestBody TweetWSentimentDB tweetDetails) throws ResourceNotFoundException {
        TweetWSentimentDB tweet = tweetWSentimentDBRepository
                .findTweetWSentimentDBByTweet_id(tweet_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tweet not found for this id :: " + tweet_id));

        tweet.setUser_id(tweetDetails.getUser_id());
        tweet.setTweet_id(tweetDetails.getTweet_id());
        tweet.setCreated_at(tweetDetails.getCreated_at());
        tweet.setUsername(tweetDetails.getUsername());
        tweet.setDisplay_name(tweetDetails.getDisplay_name());
        tweet.setTweet_text(tweetDetails.getTweet_text());
        tweet.setSentiment_score(tweetDetails.getSentiment_score());
        final TweetWSentimentDB updatedTweet = tweetWSentimentDBRepository.save(tweet);
        return ResponseEntity.ok(updatedTweet);
    }

    @DeleteMapping("/tweets/{id}")
    public Map<String, Boolean> deleteTweet(@PathVariable(value = "id") Long tweet_id)
            throws ResourceNotFoundException {
        TweetWSentimentDB tweet = tweetWSentimentDBRepository.findTweetWSentimentDBByTweet_id(tweet_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tweets not found for this tweet id :: " + tweet_id));

        tweetWSentimentDBRepository.delete(tweet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
