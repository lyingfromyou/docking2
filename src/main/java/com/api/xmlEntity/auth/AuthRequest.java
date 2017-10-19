package com.api.xmlEntity.auth;

import com.api.requestType.FnacActionType;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FnacActionType.AUTH, namespace = "http://www.fnac.com/schemas/mp-dialog.xsd")
public class AuthRequest {
	
	@XmlElement(required = true, name = "partner_id")
	private String partnerId;
	@XmlElement(required = true, name = "shop_id")
	private String shopId;
	@XmlElement(required = true)
	private String key;
	

	public static final String requestUrl = "https://vendeur.fnac.com/api.php/auth";

	public AuthRequest() {
	}

	public AuthRequest(String partnerId, String shopId, String key) {
		this.partnerId = partnerId;
		this.shopId = shopId;
		this.key = key;
	}

}
