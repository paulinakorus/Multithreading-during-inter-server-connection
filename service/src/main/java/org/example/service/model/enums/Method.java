package org.example.service.model.enums;

import org.example.service.model.Order;
import org.example.service.model.Product;
import org.example.service.model.Receipt;
import org.example.service.model.User;

public enum Method {
    Test(Product.class),
    Register(User.class),
    Unregister(Integer.class),
    GetOrder(Order.class),
    ReturnOrder(Product.class),
    GetInfo(Integer.class),
    GetOffer(),
    PutOrder(Order.class),
    ReturnReceipt(Receipt.class),
    AcceptOrder();
    private final Class<?> type;

    Method(Class<?> type) {
        this.type = type;
    }
    Method() {
        this.type = null;
    }

    public Class<?> getType() {
        return type;
    }
}
