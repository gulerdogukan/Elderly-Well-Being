package com.example.healthcare.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthcare.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class HealthServiceService {

    @Autowired
    private HealthServiceRepository healthServiceRepository;

    public List<HealthService> getAllHealthServices() {
        return healthServiceRepository.findAll();
    }

    public HealthService createHealthService(HealthService healthService) {
        return healthServiceRepository.save(healthService);
    }

    public HealthService updateHealthService(Long id, HealthService healthService) {
        HealthService existingHealthService = healthServiceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Health Service not found"));
        existingHealthService.setName(healthService.getName());
        existingHealthService.setDescription(healthService.getDescription());
        return healthServiceRepository.save(existingHealthService);
    }

    public void deleteHealthService(Long id) {
        healthServiceRepository.deleteById(id);
    }
}
