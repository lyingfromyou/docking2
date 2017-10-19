package com.api.xmlEntity.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class OrdersUpdateResponse {

	@XmlElement(name = "order")
	private ResponseOrder order;

	@XmlElement(name = "error")
	private Error error;
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public ResponseOrder getOrder() {
		return order;
	}

	public void setOrder(ResponseOrder order) {
		this.order = order;
	}

}
