package com.ktdsuniversity.edu.contacts;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;
import java.util.Scanner;

public class ContactBook {

	private List<PersonInfo> personInfoList;

	public ContactBook(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}
	
	public void searchNameNickname (String searchWord) {
		boolean found = false;
		for (int i = 0; i < personInfoList.size(); i++) {
			if (searchWord.isEmpty()) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + "(" + personInfoList.get(i).getAge() + "살)");
				found = true;
			}else if (personInfoList.get(i).getName().contains(searchWord) || personInfoList.get(i).getNickname().contains(searchWord)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + "(" + personInfoList.get(i).getAge() + "살)");
				found = true;
			}
		}
		if(!found) {
			System.out.println("해당하는 사람이 없습니다");
		}
	}
	
	public void searchNumber (String searchWord) {
		boolean found = false;
		for (int i = 0; i < personInfoList.size(); i++) {
			if(searchWord.isEmpty()) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getNumber());
				found = true;
			}else if(personInfoList.get(i).getNumber().contains(searchWord)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getNumber());
				found = true;
			}
		}
		if(!found) {
			System.out.println("등록된 연락처가 없습니다");
		}
	}
	
	public void searchUpcomingBirthday () {
		LocalDate now = LocalDate.now();
		MonthDay today = MonthDay.from(now);
		LocalDate afterStandard = LocalDate.now();
		afterStandard = afterStandard.plusDays(16);
		MonthDay afterStandardMonthDay = MonthDay.from(afterStandard);
		boolean found = false;
		for (int i = 0; i < personInfoList.size(); i++) {
			if(MonthDay.from(personInfoList.get(i).getBirthday()).isBefore(afterStandardMonthDay) && (MonthDay.from(personInfoList.get(i).getBirthday()).isAfter(today) || MonthDay.from(personInfoList.get(i).getBirthday()).equals(today))) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getBirthday());
				found = true;
			}
		}
		if(!found) {
			System.out.println("앞으로 보름 이내에 생일인 사람이 없습니다");
		}
	}
	
	public void searchWasBirthday () {
		LocalDate now = LocalDate.now();
		MonthDay today = MonthDay.from(now);
		LocalDate beforeStandard = LocalDate.now();
		beforeStandard = beforeStandard.minusDays(16);
		MonthDay afterStandardMonthDay = MonthDay.from(beforeStandard);
		boolean found = false;
		for (int i = 0; i < personInfoList.size(); i++) {
			if (MonthDay.from(personInfoList.get(i).getBirthday()).isAfter(afterStandardMonthDay) && MonthDay.from(personInfoList.get(i).getBirthday()).isBefore(today)) {
				System.out.println(i + ": " + personInfoList.get(i).getName() + ", " + personInfoList.get(i).getBirthday());
				found = true;
			}
		}
		if(!found) {
			System.out.println("지난 보름 동안 생일이었던 사람이 없습니다");
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
		if (personInfo == null || personInfo.getName().isEmpty()) {
			System.out.println("등록이 불가합니다");
			return;
		}
		personInfoList.add(personInfo);
	}
	
	public void checkPersonInfo (int index) {
		if (index >=0 && index < personInfoList.size()) {
			System.out.println(personInfoList.get(index));
		}else {
			System.out.println("해당 인덱스에 등록된 정보가 없습니다");
		}
	}
	
	public void deletePersonInfo (int index) {
		if (index >= 0 && index < personInfoList.size()) {
			System.out.println("정말로 삭제하시겠습니까?");
			System.out.println("네 혹은 아니오로 답하시오");
			Scanner keyboard = new Scanner (System.in);
			String answer = keyboard.nextLine();
			
			if(answer.equals("네")) {
				personInfoList.remove(index);
				System.out.println("삭제되었습니다");
			}else {
				System.out.println("삭제가 취소되었습니다");
			}
		}else {
			System.out.println("등록된 정보가 없습니다");
		}
	}
	
	public void editPersonInfo (int index, PersonInfo newPersonInfo) {
		if (index >= 0 && index < personInfoList.size()) {
			Scanner keyboard = new Scanner (System.in);
			System.out.println("정말로 수정하시겠습니까?");
			System.out.println("네 혹은 아니오로 답하시오");
			String answer = keyboard.nextLine();
			
			if(answer.equals("네")) {
				newPersonInfo.setRegistrationDate(personInfoList.get(index).getRegistrationDate());
				newPersonInfo.setLastUpdate(LocalDate.now());
				personInfoList.set(index, newPersonInfo);
				System.out.println("수정되었습니다");
			}else {
				System.out.println("수정이 취소되었습니다");
			}
		}else {
			System.out.println("등록된 정보가 없습니다");
		}
	}
}
