package com.repo.supportmanagement.repository;

import com.repo.supportmanagement.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncidentRepo extends JpaRepository<Incident, Long> {

    // Optional: Find all incidents by Category ID
    List<Incident> findByCategoryCategoryId(Long categoryId);

    // Optional: Find all incidents by Subcategory ID
    List<Incident> findBySubcategorySubcategoryId(Long subcategoryId);

    // Optional: Find all incidents raised by a specific user
    List<Incident> findByRaisedByUserId(Long userId);
}
