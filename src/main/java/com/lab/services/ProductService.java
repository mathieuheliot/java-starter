package com.lab.services;

import com.lab.entities.Product;
import com.lab.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> list() {
        return this.productRepository.findAll();
    }
}
