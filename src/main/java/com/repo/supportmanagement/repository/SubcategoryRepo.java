package com.repo.supportmanagement.repository;

import com.repo.supportmanagement.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {

    // Find all subcategories by category ID
    List<Subcategory> findByCategoryCategoryId(Long categoryId);
}
