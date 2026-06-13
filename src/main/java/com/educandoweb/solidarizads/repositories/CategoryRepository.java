package com.educandoweb.solidarizads.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.solidarizads.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
