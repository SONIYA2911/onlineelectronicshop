package com.onlineelectronicshop.model;

import java.util.Objects;

public class Cart {

	private Components component;
	private User user;
	private int quantity;
	private double totalPrice;
	private String status;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Components getProduct() {
		return component;
	}
	public void setProduct(Components component) {
		this.component = component;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return totalPrice;
	}
	public void setPrice(double price) {
		this.totalPrice = price;
	}
	public Cart(Components component, User user, int quantity, double price) {
		super();
		this.component = component;
		this.user = user;
		this.quantity = quantity;
		this.totalPrice = price;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(totalPrice, component, quantity, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(component, other.component) && quantity == other.quantity
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "\nproduct=" + component + "\nuser=" + user + "\nquantity=" + quantity + "\ntotalPrice=" + totalPrice
				+ "\nstatus=" + status ;
	}
	
	

}
