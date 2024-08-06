package com.ktdsuniversity.edu.contacts;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ContactBook {

	private List<PersonInfo> personInfoList;

	public ContactBook(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}
	
	public void searchNameNickname (String searchWord) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if (searchWord.isEmpty()) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + "(" + personInfoList.get(i).getAge() + "살)");
			}else if (personInfoList.get(i).getName().contains(searchWord) || personInfoList.get(i).getNickname().contains(searchWord)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + "(" + personInfoList.get(i).getAge() + "살)");
			}else {
				System.out.println("해당하는 사람이 없습니다");
			}
		}
	}
	
	public void searchNumber (String searchWord) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if(searchWord.isEmpty()) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getNumber());
			}else if(personInfoList.get(i).getNumber().contains(searchWord)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getNumber());
			}else {
				System.out.println("등록된 연락처가 없습니다");
			}
		}
	}
	
	public void searchUpcomingBirthday () {
		LocalDate now = LocalDate.now();
		LocalDate afterStandard = LocalDate.now();
		afterStandard = afterStandard.plusDays(16);
		System.out.println(afterStandard);
		for (int i = 0; i < personInfoList.size(); i++) {
			if(personInfoList.get(i).getBirthday().isBefore(afterStandard) && (personInfoList.get(i).getBirthday().isAfter(now) || personInfoList.get(i).getBirthday().isEqual(now))) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getBirthday());
			}else {
				System.out.println("앞으로 보름 이내에 생일인 사람이 없습니다");
			}
		}
	}
	
	public void searchWasBirthday () {
		LocalDate now = LocalDate.now();
		LocalDate beforeStandard = LocalDate.now();
		beforeStandard = beforeStandard.minusDays(16);
		for (int i = 0; i < personInfoList.size(); i++) {
			if (personInfoList.get(i).getBirthday().isAfter(beforeStandard) && personInfoList.get(i).getBirthday().isBefore(now)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getBirthday());
			}else {
				System.out.println("과거 보름 동안 생일이었던 사람이 없습니다");
			}
		}
	}
	
	public void searchAddress (String searchWord) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if (searchWord.isEmpty()) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getAddress().toString());
			}else if(personInfoList.get(i).getAddress().toString().contains(searchWord)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getAddress().toString());
			}else {
				System.out.println("일치하는 주소가 없습니다");
			}
		}
	}
	
	public void addPersonInfo (PersonInfo personInfo) {
		personInfoList.add(personInfo);
	}
	
	public void checkPersonInfo (int index) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if (i == index) {
				System.out.println(personInfoList.get(i));
			}
		}
	}
	
	public void deletePersonInfo (int index) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if (i == index) {
				System.out.println("정말로 삭제하시겠습니까?");
				System.out.println("네 혹은 아니오로 답하시오");
				Scanner keyboard = new Scanner (System.in);
				String answer = keyboard.nextLine();
				
				if(answer.equals("네")) {
					personInfoList.remove(index);
				}
			}
		}
	}
	
	public void editPersonInfo (int index, PersonInfo newPersonInfo) {
		for (int i = 0; i < personInfoList.size(); i++) {
			if (i == index) {
				System.out.println("정말로 수정하시겠습니까?");
				System.out.println("네 혹은 아니오로 답하시오");
				
				Scanner keyboard = new Scanner (System.in);
				String answer = keyboard.nextLine();
				
				if(answer.equals("네")) {
					personInfoList.set(index, newPersonInfo);
				}
			}
		}
	}
}
