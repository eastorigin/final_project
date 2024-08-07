package com.ktdsuniversity.edu.contacts.answer;

import java.time.LocalDate;

public class PersonInfo {

	private String name;
	private int age;
	private LocalDate birthDate;
	private Address address;
	private String nickname;
	private String contact;
	private String email;
	private LocalDate createDate;
	private LocalDate latestModifyDate;

	public PersonInfo(String name, 
					  int age, 
					  LocalDate birthDate, 
					  Address address, 
					  String nickname, 
					  String contact,
					  String email) {
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.address = address;
		this.nickname = nickname;
		this.contact = contact;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public String getNickname() {
		return nickname;
	}

	public String getContact() {
		return contact;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public LocalDate getLastestModifyDate() {
		return latestModifyDate;
	}
	
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public void setLatestModifyDate(LocalDate latestModifyDate) {
		this.latestModifyDate = latestModifyDate;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("이름: " + this.name + "\n");
		sb.append("나이: " + this.age + "\n");
		sb.append("생년월일: " + this.birthDate + "\n");
		sb.append("주소: " + this.address + "\n");
		sb.append("별명: " + this.nickname + "\n");
		sb.append("연락처: " + this.contact + "\n");
		sb.append("이메일: " + this.email + "\n");
		sb.append("추가날짜: " + this.createDate + "\n");
		sb.append("마지막 수정날짜: " + this.latestModifyDate);
		
		return sb.toString();
	}
	
}
