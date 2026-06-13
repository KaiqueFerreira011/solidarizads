package com.educandoweb.solidarizads.services;

import com.educandoweb.solidarizads.entities.Category;
import com.educandoweb.solidarizads.repositories.CategoryRepository;
import com.educandoweb.solidarizads.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        // Usa o mesmo tratamento de erro topo de linha que criamos!
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}