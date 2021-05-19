package com.springboot.javaspringtwitteranalyser.repository;

import com.springboot.javaspringtwitteranalyser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository Interface for User DB Entries
 *
 * @author Ryan Llewellyn
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.twitter_id = ?1")
    Optional<User> findUserByTwitter_id(Long twitter_id);
}
