package com.globalshipment.tracker.tracker_app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Shipment {

    private Long id;
    private String trackingNumber;
    private String origin;
    private String destination;
    private BigDecimal cost;
    private LocalDateTime createdAt;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<TrackingEvent> events;
}
