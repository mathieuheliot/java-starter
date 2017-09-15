package com.lab.repositories;

import com.lab.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();
}
