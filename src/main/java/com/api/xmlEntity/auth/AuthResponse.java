package com.api.xmlEntity.auth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "auth_response")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthResponse {

	@XmlElement(required = true)
	private String token;
	@XmlElement(required = true)
	private String validity;
	@XmlElement(required = true)
	private String version;

	public Date getValidityDate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		try {
			return format.parse(this.validity);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
