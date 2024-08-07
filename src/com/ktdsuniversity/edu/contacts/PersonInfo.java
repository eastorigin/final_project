package com.ktdsuniversity.edu.contacts;

import java.time.LocalDate;

public class PersonInfo {

	private String name;
	private int age;
	private LocalDate birthday;
	private Address address;
	private String nickname;
	private String number;
	private String eMail;
	private LocalDate registrationDate;
	private LocalDate lastUpdate;
	
	public PersonInfo(String name, int age, LocalDate birthday, Address address, String nickname, String number,
			String eMail, LocalDate registrationDate, LocalDate lastUpdate) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
		this.nickname = nickname;
		this.number = number;
		this.eMail = eMail;
		this.registrationDate = registrationDate;
		this.lastUpdate = lastUpdate;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public Address getAddress() {
		return address;
	}
	public String getNickname() {
		return nickname;
	}
	public String getNumber() {
		return number;
	}
	public String geteMail() {
		return eMail;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}
	
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Override
	public String toString() {
		return "이름: " + this.name + ", 나이: " + this.age + ", 생일: " + this.birthday + ", 주소: " + this.address + " 별명: " + this.nickname + "연락처: " + this.number + "이메일: " + this.eMail + "등록일: " + this.registrationDate + "마지막 수정일: " + this.lastUpdate;
	}
}
