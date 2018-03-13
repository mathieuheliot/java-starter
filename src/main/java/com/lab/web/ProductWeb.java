package com.lab.web;

import com.lab.entities.Product;
import com.lab.controllers.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductWeb {

    @Autowired
    private ProductController productController;

    @RequestMapping("/")
    public String all(Model model) {

        List<Product> productList = this.productController.getAll();

        model.addAttribute("products", productList);

        return "products";
    }
}
