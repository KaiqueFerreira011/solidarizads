package com.educandoweb.solidarizads.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.solidarizads.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
