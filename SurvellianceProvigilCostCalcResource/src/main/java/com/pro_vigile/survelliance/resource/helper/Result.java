package com.pro_vigile.survelliance.resource.helper;

import java.io.Serializable;

public class Result implements Serializable {
	private int subscription_id;
	private double cost;
	public int getSubscription_id() {
		return subscription_id;
	}
	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
