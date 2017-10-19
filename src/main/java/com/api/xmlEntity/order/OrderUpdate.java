package com.api.xmlEntity.order;

import com.constentEnum.OrderUpdateAction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class OrderUpdate {
	
	@XmlAttribute(name = "order_id")
	private String orderId;

	@XmlAttribute(name = "action")
	private String action;
	

	@XmlElement(name = "order_detail")
	private OrderDetailUpdate orderDetail;

	public OrderUpdate() {}
	
	public OrderUpdate(String orderId, OrderUpdateAction action, OrderDetailUpdate orderDetail) {
		this.orderId = orderId;
		this.action = action.getAction();
		this.orderDetail = orderDetail;
	}
	
	public OrderDetailUpdate getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetailUpdate orderDetail) {
		this.orderDetail = orderDetail;
	}

}

