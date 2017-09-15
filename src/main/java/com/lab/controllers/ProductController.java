package com.lab.controllers;

import com.lab.entities.Product;
import com.lab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll() {

        List<Product> productList = this.productService.list();

        return productList;
    }
}
