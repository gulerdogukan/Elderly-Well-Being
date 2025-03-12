package com.example.healthcare.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class HealthServiceController {

    @Autowired
    private HealthServiceService healthServiceService;

    @GetMapping
    public List<HealthService> getAllHealthServices() {
        return healthServiceService.getAllHealthServices();
    }

    @PostMapping
    public HealthService createHealthService(@RequestBody HealthService healthService) {
        return healthServiceService.createHealthService(healthService);
    }

    @PutMapping("/{id}")
    public HealthService updateHealthService(@PathVariable Long id, @RequestBody HealthService healthService) {
        return healthServiceService.updateHealthService(id, healthService);
    }

    @DeleteMapping("/{id}")
    public void deleteHealthService(@PathVariable Long id) {
        healthServiceService.deleteHealthService(id);
    }
}
