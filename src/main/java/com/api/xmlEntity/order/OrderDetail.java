package com.api.xmlEntity.order;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDetail {

	@XmlElement(name = "product_name")
	private String productName;// 商品描述
	@XmlElement(name = "quantity")
	private Integer quantity;
	@XmlElement(name = "price")
	private BigDecimal price;// 毛收入 （净收入=毛收入-支付费）
	@XmlElement(name = "fees")
	private BigDecimal fees;// 支付费
	@XmlElement(name = "product_fnac_id")
	private String productFnacId;// item id
	@XmlElement(name = "offer_seller_id")
	private String offerSellerId;// SKU

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public String getProductFnacId() {
		return productFnacId;
	}

	public void setProductFnacId(String productFnacId) {
		this.productFnacId = productFnacId;
	}

	public String getOfferSellerId() {
		return offerSellerId;
	}

	public void setOfferSellerId(String offerSellerId) {
		this.offerSellerId = offerSellerId;
	}

}
