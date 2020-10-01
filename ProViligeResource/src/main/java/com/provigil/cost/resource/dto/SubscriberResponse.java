package com.provigil.cost.resource.dto;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType

public class SubscriberResponse {
	@XmlElement(name="subscriber")
	private List<SubscriberResponseDto> listSubscriberResponse;

	public List<SubscriberResponseDto> getListSubscriberResponse() {
		return listSubscriberResponse;
	}

	public void setListSubscriberResponse(List<SubscriberResponseDto> listSubscriberResponse) {
		this.listSubscriberResponse = listSubscriberResponse;
	}
	

}
