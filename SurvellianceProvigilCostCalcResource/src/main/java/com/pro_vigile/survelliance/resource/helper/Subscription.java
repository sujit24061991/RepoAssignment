package com.pro_vigile.survelliance.resource.helper;

import java.io.Serializable;

public class Subscription implements Serializable {
	private int subscription_id;
	private float area;
	private String plan;
	private String location;
	public int getSubscription_id() {
		return subscription_id;
	}
	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
