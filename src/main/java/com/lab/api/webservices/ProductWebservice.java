package com.lab.api.webservices;

import com.lab.api.dto.outputs.ProductOutput;
import com.lab.api.mappers.ProductMapper;
import com.lab.controllers.ProductController;
import com.lab.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductWebservice {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/")
    public List<ProductOutput> list(Model model) {

        List<Product> productList = this.productController.getAll();
        List<ProductOutput> productOutputList = this.productMapper.mapToProductOutputList(productList);

        return productOutputList;
    }
}
