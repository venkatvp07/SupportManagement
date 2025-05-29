package com.repo.supportmanagement.repository;

import com.repo.supportmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
