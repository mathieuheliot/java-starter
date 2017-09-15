package com.lab.api.mappers;

import com.lab.api.dto.outputs.IOutput;
import com.lab.api.dto.outputs.ProductOutput;
import com.lab.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProductMapper implements IOutput {

    public ProductOutput mapToOutput(Product product) {

        ProductOutput productOutput = new ProductOutput();
        productOutput.id = product.getId();
        productOutput.name = product.getName();

        return productOutput;
    }

    public List<ProductOutput> mapToProductOutputList(List<Product> productList) {

        List<ProductOutput> productOutputList = new ArrayList<>();
        Iterator<Product> productIterator = productList.iterator();
        while ( productIterator.hasNext() ) {
            Product product = productIterator.next();
            ProductOutput productOutput = this.mapToOutput(product);
            productOutputList.add(productOutput);
        }

        return productOutputList;
    }
}
