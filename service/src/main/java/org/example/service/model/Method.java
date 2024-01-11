package org.example.service.model;

public enum Method {
    Test(Product.class),
    Register(User.class),
    Unregister(Integer.class),
    GetOrder(UserProducts.class),
    ReturnOrder(Product.class),
    GetInfo(Integer.class),
    GetOffer(Integer.class),
    PutOrder(UserProducts.class);
    private final Class<?> type;

    Method(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }
}
