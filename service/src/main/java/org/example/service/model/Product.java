package org.example.service.model;

import org.example.service.model.enums.ProductStatus;
import org.example.service.model.enums.ProductStatusAtSeller;

public class Product {
    private Integer id;
    private String name;
    private ProductStatus productStatus;
    private ProductStatusAtSeller productStatusAtSeller;        // changing because of the buttons

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public ProductStatusAtSeller getProductStatusAtSeller() {
        return productStatusAtSeller;
    }

    public void setProductStatusAtSeller(ProductStatusAtSeller productStatusAtSeller) {
        this.productStatusAtSeller = productStatusAtSeller;
    }
}
