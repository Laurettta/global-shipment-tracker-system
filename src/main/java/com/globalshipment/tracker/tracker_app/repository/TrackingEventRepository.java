package com.globalshipment.tracker.tracker_app.repository;

import com.globalshipment.tracker.tracker_app.model.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}
