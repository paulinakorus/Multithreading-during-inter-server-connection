package org.example.service.model;

public enum Method {
    Test(Product.class), Register(User.class);
    private final Class<?> type;

    Method(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }
}
