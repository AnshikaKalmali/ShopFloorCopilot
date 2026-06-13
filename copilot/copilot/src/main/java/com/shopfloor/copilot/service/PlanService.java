package com.shopfloor.copilot.service;

import com.shopfloor.copilot.DailyPlan;
import com.shopfloor.copilot.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlanService {

    private final ClaudeService claudeService;
    private final PlanRepository planRepository;

    public PlanService(ClaudeService claudeService, PlanRepository planRepository) {
        this.claudeService = claudeService;
        this.planRepository = planRepository;
    }

    public DailyPlan generateAndSavePlan(String situation,
                                         int totalWorkers,
                                         int presentWorkers) {
        // 1. Ask Claude for a plan
        String aiPlan = claudeService.generatePlan(situation);

        // 2. Save it to the database
        DailyPlan plan = new DailyPlan();
        plan.setPlanDate(LocalDate.now());
        plan.setTotalWorkers(totalWorkers);
        plan.setPresentWorkers(presentWorkers);
        plan.setSituationSummary(situation);
        plan.setAiPlan(aiPlan);
        plan.setFollowed(false);

        return planRepository.save(plan);
    }

    public List<DailyPlan> getAllPlans() {
        return planRepository.findAllByOrderByPlanDateDesc();
    }
}