package com.api.xmlEntity.order;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class States {

	@XmlElement(name = "state")
	private List<String> states;

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public States() {
	}

	public States(List<String> states) {
		this.states = states;
	}
}
