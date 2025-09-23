package com.globalshipment.tracker.tracker_app.repository;

import com.globalshipment.tracker.tracker_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
