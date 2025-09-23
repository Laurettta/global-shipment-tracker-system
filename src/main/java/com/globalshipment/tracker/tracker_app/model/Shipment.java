package com.globalshipment.tracker.tracker_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;
    private String origin;
    private String destination;
    private BigDecimal cost;
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<TrackingEvent> events;
}
