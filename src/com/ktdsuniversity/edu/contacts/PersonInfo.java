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
	
	
}
