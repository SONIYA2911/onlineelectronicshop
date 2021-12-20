package com.onlineelectronicshop.model;

import java.util.Objects;

public class User {

	private String user_name;
	private String email_id;
	private String password;
	private Long contactNumber;
	private String address;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String user_name, String email_id, String password, Long contact_number, String address) {
		super();
		this.user_name = user_name;
		this.email_id = email_id;
		this.password = password;
		this.contactNumber = contact_number;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [user_name:" + user_name + ", email_id:" + email_id + ", password:" + password
				+ ", contact_number:" + contactNumber + ", address:" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactNumber, email_id, password, user_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(email_id, other.email_id) && Objects.equals(password, other.password)
				&& Objects.equals(user_name, other.user_name);
	}

	
}
