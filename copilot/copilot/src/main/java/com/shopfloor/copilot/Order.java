package com.shopfloor.copilot;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String description;
    private String priority;
    private String status;
    private boolean materialReady;
    private String materialArrivalTime;
}