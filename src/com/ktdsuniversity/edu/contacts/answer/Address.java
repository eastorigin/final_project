package com.ktdsuniversity.edu.contacts.answer;

public class Address {

	private String city;
	private String state;
	private String streetAddress;
	private String buildingNumbers;
	private String detailAddress;
	private String postalCode;

	public Address(String city, 
				   String state, 
				   String streetAddress, 
				   String buildingNumbers, 
				   String detailAddress,
				   String postalCode) {
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.buildingNumbers = buildingNumbers;
		this.detailAddress = detailAddress;
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getBuildingNumbers() {
		return buildingNumbers;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}
	
	public String getAddressInfo() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("시/군/구: " + this.city + "\n");
		sb.append("읍/면/동: " + this.state + "\n");
		sb.append("도로명주소: " + this.streetAddress + "\n");
		sb.append("지번주소: " + this.buildingNumbers + "\n");
		sb.append("상세주소: " + this.detailAddress + "\n");
		sb.append("우편번호: " + this.postalCode);
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return this.city + " " 
				+ this.state + " " 
				+ this.streetAddress + " " 
				+ this.buildingNumbers + " " 
				+ this.detailAddress + " " 
				+ this.postalCode;
	}
	
}
