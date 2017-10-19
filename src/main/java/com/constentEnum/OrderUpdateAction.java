package com.constentEnum;

public enum OrderUpdateAction {

    ACCEPT_ORDER("accept_order"), // 订单的操作是接受卖方的订单
    CONFIRM_TO_SEND("confirm_to_send"), // 该订单的行动是确认卖方发送订单
    UPDATE("update"), // 订单的行动是卖方更新订单
    ACCEPT_ALL_ORDERS("accept_all_orders"), // 该订单的行为是接受或拒绝卖方订单的所有订单
    CONFIRM_ALL_TO_SEND("confirm_all_to_send"), // 订单的操作是确认卖方发送所有订单详细信息
    UPDATE_ALL("update_all");// 订单的操作是更新所有订单详细信息的跟踪信息

    String action;

    OrderUpdateAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
