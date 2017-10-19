package com.constentEnum;

public enum OrderDetailStateUpdate {

    ACCEPTED("Accepted"),//: The line has been accepted by the seller
    REFUSED("Refused"),//: The line has been refused by the seller
    SHIPPED("Shipped"),//: The line has been shipped by the seller, an optional tracking number can be specified
    REFUNDED("Refunded"),//: The line has been refunded by the seller or by fnac
    UPDATED("Updated");//: The line has been updated by the seller

    private String state;

    OrderDetailStateUpdate(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
