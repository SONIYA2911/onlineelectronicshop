package com.onlineelectronicshop.model;

import java.util.Objects;

public class Invoice {

	private Components component;
	private User user;
	private Cart cart;
	private double finalPrice;
	public Components getComponent() {
		return component;
	}
	public void setComponent(Components component) {
		this.component = component;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Invoice(Components component, User user, Cart cart, double finalPrice) {
		super();
		this.component = component;
		this.user = user;
		this.cart = cart;
		this.finalPrice = finalPrice;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invoice [component=" + component + ", user=" + user + ", cart=" + cart + ", finalPrice=" + finalPrice
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cart, component, finalPrice, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(component, other.component)
				&& Double.doubleToLongBits(finalPrice) == Double.doubleToLongBits(other.finalPrice)
				&& Objects.equals(user, other.user);
	}
}