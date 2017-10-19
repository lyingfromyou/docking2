package com.api.xmlEntity.order;

import com.api.requestType.FnacActionType;
import com.api.xmlEntity.BaseRequest;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FnacActionType.ORDERS_QUERY)
public class OrdersQueryRequest extends BaseRequest {

	@XmlAttribute(name = "results_count")
	private Integer count;// 查询返回的数量

	@XmlElement(name = "paging")
	private Integer paging;// 第几页

	@XmlElement(name = "states")
	private States states;

	@XmlElement(name = "orders_fnac_id")
	private OrdersFnacId ordersFnacId;// 交易号

	public OrdersQueryRequest() {
	}

	public OrdersQueryRequest(String partnerId, String shopId, String token) {
		this.partnerId = partnerId;
		this.shopId = shopId;
		this.token = token;
	}

}
