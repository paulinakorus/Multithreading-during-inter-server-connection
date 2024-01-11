package org.example.service.model;

public enum Method {
    Test(Product.class),
    Register(User.class),
    Unregister(Integer.class),
    GetOrder(Order.class),
    ReturnOrder(Product.class),
    GetInfo(Integer.class),
    GetOffer(),
    PutOrder(Order.class);
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
