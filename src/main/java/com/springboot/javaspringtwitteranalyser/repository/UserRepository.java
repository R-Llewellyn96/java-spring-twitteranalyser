package com.springboot.javaspringtwitteranalyser.repository;

import com.springboot.javaspringtwitteranalyser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for User DB Entries
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
