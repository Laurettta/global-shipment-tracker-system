package com.globalshipment.tracker.tracker_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TrackingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
}
