package com.repo.supportmanagement.controller;

import com.repo.supportmanagement.model.*;
import com.repo.supportmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private SubcategoryRepo subcategoryRepo;

    @Autowired
    private IncidentRepo incidentRepo;

    @Autowired
    private UserRepo userRepo;  // to validate user (optional)


    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }


    @GetMapping("/categories/{categoryId}/subcategories")
    public List<Subcategory> getSubcategoriesByCategory(@PathVariable Long categoryId) {
        return subcategoryRepo.findByCategoryCategoryId(categoryId);
    }


    @PostMapping(value = "/raise", consumes = "application/json")
    public String raiseIncident(@RequestBody Incident incident) {

        if (!userRepo.existsById(incident.getRaisedBy().getUserId())) {
            return "User not found or unauthorized";
        }

        Incident savedIncident = incidentRepo.save(incident);
        return "Incident raised successfully with ID: " + savedIncident.getIncidentId();
    }

    @GetMapping("/user/{userId}")
    public List<Incident> getIncidentsByUser(@PathVariable Long userId) {
        return incidentRepo.findByRaisedByUserId(userId);
    }

}
