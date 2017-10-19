package com.constentEnum;

public enum OrderState {

    Created("Created"), // 订单正在等待卖家的批准
    Accepted("Accepted"), // 该订单已被卖方批准（甚至部分），并正在等待结算和付款
    Refused("Refused"), // 卖家已经完全拒绝该订单（终端状态）
    ToShip("ToShip"), // 该订单已经被卖方批准并收费，并正在等待卖方装运
    Shipped("Shipped"), // 该订单已经被卖方批准，收费和发货，并且正在等待客户知道
    NotReceived("NotReceived"), // 客户声称部分或全部产品尚未收到。 这种情况将由客户服务管理
    Received("Received"), // 订单完成后，客户收到所有产品和确认接收（终端状态）
    Cancelled("Cancelled"), // 订单已被客户（终端状态）或fnac服务取消
    Refunded("Refunded"), // 卖家（终端状态）或fnac服务已退还订单
    Error("Error");// 订单状态处于非授权或不合逻辑状态

    String state;

    OrderState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
