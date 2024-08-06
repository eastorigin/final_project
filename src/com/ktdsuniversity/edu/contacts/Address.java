package com.ktdsuniversity.edu.contacts;

public class Address {

	private String city;
	private String district;
	private String street;
	private String previousStreet;
	private String detail;
	private String postalCode;
	public Address(String city, String district, String street, String previousStreet, String detail,
			String postalCode) {
		
		this.city = city;
		this.district = district;
		this.street = street;
		this.previousStreet = previousStreet;
		this.detail = detail;
		this.postalCode = postalCode;
	}
	
	
}
