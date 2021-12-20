package com.onlineelectronicshop.model;

import java.sql.Date;
import java.util.Objects;

public class Orders {

private String orderId;
private String componentId;
private String categoryName;
private int quantity;
private double totalPrice;
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getComponentId() {
	return componentId;
}
public void setComponentId(String componentId) {
	this.componentId = componentId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryId(String categoryName) {
	this.categoryName = categoryName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public Orders(String orderId, String componentId, String categoryName, int quantity, double totalPrice) {
	super();
	this.orderId = orderId;
	this.componentId = componentId;
	this.categoryName = categoryName;
	this.quantity = quantity;
	this.totalPrice = totalPrice;
}
@Override
public int hashCode() {
	return Objects.hash(categoryName, componentId, orderId, quantity, totalPrice);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orders other = (Orders) obj;
	return Objects.equals(categoryName, other.categoryName) && Objects.equals(componentId, other.componentId)
			&& Objects.equals(orderId, other.orderId) && quantity == other.quantity
			&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
}

	

	
	
	
	
}
