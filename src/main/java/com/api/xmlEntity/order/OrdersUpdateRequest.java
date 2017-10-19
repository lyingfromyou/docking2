package com.api.xmlEntity.order;

import com.api.requestType.FnacActionType;
import com.api.xmlEntity.BaseRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FnacActionType.ORDERS_UPDATE)
public class OrdersUpdateRequest extends BaseRequest {
	
	@XmlElement(name = "order")
	private OrderUpdate order;

	public OrdersUpdateRequest() {
	}

	public OrdersUpdateRequest(String partnerId, String shopId, String token, OrderUpdate orderUpdate) {
		this.partnerId = partnerId;
		this.shopId = shopId;
		this.token = token;
		this.order = orderUpdate;
	}

	public OrderUpdate getOrder() {
		return order;
	}

	public void setOrder(OrderUpdate order) {
		this.order = order;
	}

}
