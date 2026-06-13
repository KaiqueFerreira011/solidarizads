package com.educandoweb.solidarizads.services;

import com.educandoweb.solidarizads.entities.Product;
import com.educandoweb.solidarizads.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
}
