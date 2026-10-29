package com.samuel.webservices.enums;

public enum OrderStatus {

    WAITING_PAYMENT(10),
    PAID(20),
    SHIPPED(30),
    DELIVERED(40),
    CANCELED(50);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus getOrderStatus(int code) {

        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid order status code.");

    }


}
