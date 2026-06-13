package com.shopfloor.copilot.repository;

import com.shopfloor.copilot.DailyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanRepository extends JpaRepository<DailyPlan, Long> {
    List<DailyPlan> findAllByOrderByPlanDateDesc();
}