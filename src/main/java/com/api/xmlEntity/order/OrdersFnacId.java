package com.api.xmlEntity.order;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersFnacId {
	@XmlElement(name = "order_fnac_id")
	private List<String> orderFnacId;

	public List<String> getOrderFnacId() {
		return orderFnacId;
	}

	public void setOrderFnacId(List<String> orderFnacId) {
		this.orderFnacId = orderFnacId;
	}

	public OrdersFnacId() {
	}

	public OrdersFnacId(List<String> orderFnacId) {
		this.orderFnacId = orderFnacId;
	}
}
