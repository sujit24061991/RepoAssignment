package com.provigil.cost.resource.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="subscriptions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Subscription {
	@XmlElement(name="subscription")
	private List<SubscriberRequestDto> subscriberRequestDto;

	public List<SubscriberRequestDto> getSubscriberRequestDto() {
		return subscriberRequestDto;
	}

	public void setSubscriberRequestDto(List<SubscriberRequestDto> subscriberRequestDto) {
		this.subscriberRequestDto = subscriberRequestDto;
	}
	

	
	

}
