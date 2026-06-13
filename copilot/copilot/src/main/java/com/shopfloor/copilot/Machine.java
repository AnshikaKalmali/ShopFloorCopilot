package com.shopfloor.copilot;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "machines")
@Data
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // e.g. "Machine 1"
    private String status;      // "online", "slow", "offline"
    private String notes;       // e.g. "running hot today"
}