package com.globalshipment.tracker.tracker_app.model;

import com.globalshipment.tracker.tracker_app.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
