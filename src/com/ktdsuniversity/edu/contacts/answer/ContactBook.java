package com.ktdsuniversity.edu.contacts.answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactBook {

	private List<PersonInfo> contacts;
	
	public ContactBook() {
		this.contacts = new ArrayList<>();
	}
	
	public void printSearchResultByNameOrNickname(String nameOrNickname) {
		if (nameOrNickname == null) {
			nameOrNickname = "";
		}
		nameOrNickname = nameOrNickname.trim();
		
		boolean isFound = false;
		for (int i = 0; i < this.contacts.size(); i++) {
			PersonInfo personInfo = this.contacts.get(i);
			
			String name = personInfo.getName() + " " + personInfo.getNickname();
			if (name.contains(nameOrNickname) || nameOrNickname.equals("")) {
				isFound = true;
				System.out.println(i + " " + personInfo.getName() + "(" + personInfo.getAge() + ")");
			}
		}
		
		if (!isFound) {
			System.out.println("해당하는 사람이 없습니다.");
		}
	}
	
	public void printSearchResultByContact(String contact) {
		if (contact == null) {
			contact = "";
		}
		contact = contact.trim();
		
		boolean isFound = false;
		for (int i = 0; i < this.contacts.size(); i++) {
			PersonInfo personInfo = this.contacts.get(i);
			String personsContact = personInfo.getContact();
			if (personsContact.contains(contact) || contact.equals("")) {
				isFound = true;
				System.out.println(i + " " + personInfo.getName() + "(" + personInfo.getAge() + ")");
			}
		}
		
		if (!isFound) {
			System.out.println("해당하는 연락처가 없습니다.");
		}
	}
	
	public void printSearchResultByAddress(String address) {
		if (address == null) {
			address = "";
		}
		address = address.trim();
		
		boolean isFound = false;
		for (int i = 0; i < this.contacts.size(); i++) {
			PersonInfo personInfo = this.contacts.get(i);
			String personsAddress = personInfo.getAddress().toString();
			
			if (personsAddress.contains(address) || address.equals("")) {
				isFound = true;
				System.out.println(i + " " + personInfo.getName() + "(" + personInfo.getAge() + ")");
			}
		}
		
		if (!isFound) {
			System.out.println("해당 주소에 사는 사람이 없습니다.");
		}
	}
	
	public void printSearchResultByFutureBirthDate() {
		LocalDate now = LocalDate.now();
		LocalDate futureDate = now.plusDays(15);
		
		boolean isFound = false;
		for (int i = 0; i < this.contacts.size(); i++) {
			PersonInfo personInfo = this.contacts.get(i);
			LocalDate birthDate = personInfo.getBirthDate();
			
			// 생일의 연도를 현재 연도로 변경
			birthDate = birthDate.withYear(now.getYear());
			
			if ( (birthDate.isAfter(now) || birthDate.equals(now)) 
					&& (birthDate.isBefore(futureDate) || birthDate.isEqual(futureDate))) {
				isFound = true;
				System.out.println(i + " " + personInfo.getName() + "(" + personInfo.getAge() + ")");
			}
		}
		
		if (!isFound) {
			System.out.println("보름내에 생일인 사람이 없습니다.");
		}
	}
	
	public void printSearchResultByPastBirthDate() {
		LocalDate yesterday = LocalDate.now().minusDays(1);
		LocalDate pastDate = yesterday.minusDays(15);
		
		boolean isFound = false;
		for (int i = 0; i < this.contacts.size(); i++) {
			PersonInfo personInfo = this.contacts.get(i);
			LocalDate birthDate = personInfo.getBirthDate();
			
			// 생일의 연도를 어제 연도로 변경
			birthDate = birthDate.withYear(yesterday.getYear());
			
			if ( (birthDate.isBefore(yesterday) || birthDate.equals(yesterday)) 
					&& (birthDate.isAfter(pastDate) || birthDate.isEqual(pastDate))) {
				isFound = true;
				System.out.println(i + " " + personInfo.getName() + "(" + personInfo.getAge() + ")");
			}
		}
		
		if (!isFound) {
			System.out.println("최근에 생일이 지난 사람이 없습니다.");
		}
	}
	
	public void addNewPersonInfo(PersonInfo newPersonInfo) {
		if (newPersonInfo == null) {
			throw new IllegalArgumentException("등록할 수 없습니다.");
		}
		
		String name = newPersonInfo.getName();
		if (name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("등록할 수 없습니다.");
		}
		
		newPersonInfo.setCreateDate(LocalDate.now());
		
		this.contacts.add(newPersonInfo);
		System.out.println("주소록에 총 " + this.contacts.size() + "명의 사람이 있습니다.");
	}
	
	public boolean printSearchByIndex(int index) {
		if (index >= this.contacts.size() || index < 0) {
			System.out.println("존재하지 않는 사람입니다.");
			return false;
		}
		
		System.out.println(this.contacts.get(index));
		return true;
	}
	
	public void deleteOnePersonInfoByIndex(int index) {
		if (index >= this.contacts.size() || index < 0) {
			System.out.println("존재하지 않는 사람입니다.");
			return;
		}
		PersonInfo personInfo = this.contacts.get(index);
		String message = "%s (%d)를 정말 삭제하겠습니까? (y/n)";
		System.out.println(String.format(message, personInfo.getName(), personInfo.getAge()));
		
		Scanner keyboard = new Scanner(System.in);
		String yesOrNo = keyboard.nextLine().trim().toLowerCase();
		
		if (yesOrNo.equals("y")) {
			this.contacts.remove(index);
			System.out.println("삭제가 완료되었습니다.");
		}
		else {
			System.out.println("삭제가 취소되었습니다.");
		}
	}
	
	public void modifyOnePersonInfoByIndex(int index, PersonInfo modifiedPersonInfo) {
		if (index >= this.contacts.size() || index < 0) {
			System.out.println("존재하지 않는 사람입니다.");
			return;
		}
		if (modifiedPersonInfo == null) {
			throw new IllegalArgumentException("수정할 수 없습니다.");
		}
		String name = modifiedPersonInfo.getName();
		if (name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("수정할 수 없습니다.");
		}
		
		PersonInfo personInfo = this.contacts.get(index);
		
		String message = "%s (%d)를 정말 수정하겠습니까? (y/n)";
		System.out.println(String.format(message, personInfo.getName(), personInfo.getAge()));
		
		Scanner keyboard = new Scanner(System.in);
		String yesOrNo = keyboard.nextLine().trim().toLowerCase();
		
		if (yesOrNo.equals("y")) {
			modifiedPersonInfo.setCreateDate(personInfo.getCreateDate());
			modifiedPersonInfo.setLatestModifyDate(LocalDate.now());
			
			this.contacts.set(index, modifiedPersonInfo);
			System.out.println("수정이 완료되었습니다.");
		}
		else {
			System.out.println("수정이 취소되었습니다.");
		}
	}
	
}
