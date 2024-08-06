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
	
	@Override
	public String toString() {
		return "시/군/구: " + this.city + ", 읍/면/동: " + this.district + ", 길 (도로명주소): " + this.street + ", 번지(구 주소): " + this.previousStreet + ", 동/호수 (상세주소): " + this.detail + ", 우편번호: " + this.postalCode;
	}
}
