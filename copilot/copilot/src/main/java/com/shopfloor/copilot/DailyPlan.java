package com.shopfloor.copilot;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "daily_plans")
@Data
public class DailyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate planDate;
    private int totalWorkers;
    private int presentWorkers;

    @Column(columnDefinition = "TEXT")
    private String situationSummary;  // what supervisor typed in

    @Column(columnDefinition = "TEXT")
    private String aiPlan;            // what Claude returned

    private boolean followed;
}