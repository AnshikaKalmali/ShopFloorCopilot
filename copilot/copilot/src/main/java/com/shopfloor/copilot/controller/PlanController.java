package com.shopfloor.copilot.controller;

import com.shopfloor.copilot.DailyPlan;
import com.shopfloor.copilot.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin(origins = "*")  // allows React to call this API
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    // POST /api/plans/generate — React calls this
    @PostMapping("/generate")
    public DailyPlan generatePlan(@RequestBody PlanRequest request) {
        return planService.generateAndSavePlan(
                request.situation(),
                request.totalWorkers(),
                request.presentWorkers()
        );
    }

    // GET /api/plans — get all past plans
    @GetMapping
    public List<DailyPlan> getAllPlans() {
        return planService.getAllPlans();
    }

    // Record = compact Java class for receiving JSON data
    public record PlanRequest(
            String situation,
            int totalWorkers,
            int presentWorkers
    ) {}
}