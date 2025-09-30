package com.globalshipment.tracker.tracker_app.repository;

import com.globalshipment.tracker.tracker_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Find a user by email (used for login)
    Optional<User> findByEmail(String email);
}
