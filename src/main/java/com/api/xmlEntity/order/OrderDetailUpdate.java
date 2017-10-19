package com.api.xmlEntity.order;

import com.constentEnum.OrderDetailStateUpdate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDetailUpdate {
	
	@XmlElement(name = "order_detail_id")
	private Integer orderDetailId;

	@XmlElement(name = "action")
	private String orderDetailUpdateAction;

	@XmlElement(name = "tracking_number")
	private String trackingNumber;

	@XmlElement(name = "tracking_company")
	private String trackingCompany; 
	
	@XmlElement(name = "tracking_client_id")
	private String trackingClientId;
	
	
	public OrderDetailUpdate() {
	}

	public OrderDetailUpdate(OrderDetailStateUpdate action) {
		this.orderDetailUpdateAction = action.getState();
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getOrderDetailUpdateAction() {
		return orderDetailUpdateAction;
	}

	public void setOrderDetailUpdateAction(String orderDetailUpdateAction) {
		this.orderDetailUpdateAction = orderDetailUpdateAction;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getTrackingCompany() {
		return trackingCompany;
	}

	public void setTrackingCompany(String trackingCompany) {
		this.trackingCompany = trackingCompany;
	}

	public String getTrackingClientId() {
		return trackingClientId;
	}

	public void setTrackingClientId(String trackingClientId) {
		this.trackingClientId = trackingClientId;
	}

}
