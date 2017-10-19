package com.api.xmlEntity.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseOrder {

	@XmlElement
	private String status;

	@XmlElement(name = "order_id")
	private String orderId;

	@XmlElement
	private String state;

	@XmlElement(name = "order_detail")
	private ResponceOrderDetail orderDetail;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ResponceOrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ResponceOrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}
