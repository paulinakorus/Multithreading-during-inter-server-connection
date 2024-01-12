package org.example.service.model;

import org.example.service.model.enums.OrderStatus;

import java.util.List;

public class Order {
    private Integer userID;
    private List<Product> productList;
    private OrderStatus orderStatus;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
