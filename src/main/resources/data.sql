DROP TABLE IF EXISTS usertb, tweetwsentimentdb;

CREATE TABLE usertb (
    twitter_id INT PRIMARY KEY
);

CREATE TABLE tweetwsentimentdb (
                                   db_id INT AUTO_INCREMENT PRIMARY KEY,
                                   user_id INT NOT NULL,
                                   tweet_id INT NOT NULL UNIQUE,
                                   created_at VARCHAR(250) NOT NULL,
                                   username VARCHAR(250) NOT NULL,
                                   display_name VARCHAR(250) NOT NULL,
                                   tweet_text VARCHAR(250) NOT NULL,
                                   sentiment_score VARCHAR(250) NOT NULL
);

INSERT INTO usertb (twitter_id) VALUES
(123),
(456),
(789);

INSERT INTO tweetwsentimentdb (user_id, tweet_id, created_at, username, display_name, tweet_text, sentiment_score) VALUES
(123, 1, '2021-05-10', 'testuser', 'tester', 'this is a test tweet', '2'),
(123, 2, '2021-05-10', 'testuser2', 'tester2', 'this is a test tweet2', '2'),
(123, 3, '2021-05-10', 'testuser2', 'tester2', 'this is a test tweet2', '2');