package com.ktdsuniversity.edu.contacts.answer;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	private ContactBook contactBook;
	private Scanner keyboard;
	
	public Main() {
		this.contactBook = new ContactBook();
		this.keyboard = new Scanner(System.in);
	}
	
	public int printAndSelectMenu() {
		System.out.println("=".repeat(50));
		System.out.println("메뉴를 선택하세요.");
		System.out.println("  1. 등록");
		System.out.println("  2. 이름 + 별명 검색");
		System.out.println("  3. 연락처 검색");
		System.out.println("  4. 다가오는 생일자 검색");
		System.out.println("  5. 지나간 생일자 검색");
		System.out.println("  6. 주소 검색");
		System.out.println("  7. 한사람 조회");
		System.out.println("  9. 종료");
		System.out.println("번호를 입력하세요.");
		
		try {
			return this.keyboard.nextInt();
		}
		finally {
			this.keyboard.nextLine();
		}
	}
	
	public void search(int selectedMenu) {
		if (selectedMenu == 2) {
			System.out.println("검색할 이름 혹은 별명을 입력하세요.");
			String nameOrNickname = this.keyboard.nextLine();
			this.contactBook.printSearchResultByNameOrNickname(nameOrNickname);
		}
		else if (selectedMenu == 3) {
			System.out.println("검색할 연락처를 입력하세요.");
			String contact = this.keyboard.nextLine();
			this.contactBook.printSearchResultByContact(contact);
		}
		else if (selectedMenu == 4) {
			this.contactBook.printSearchResultByFutureBirthDate();
		}
		else if (selectedMenu == 5) {
			this.contactBook.printSearchResultByPastBirthDate();
		}
		else if (selectedMenu == 6) {
			System.out.println("검색할 주소를 입력하세요.");
			String address = this.keyboard.nextLine();
			this.contactBook.printSearchResultByAddress(address);
		}
	}
	
	public void addNewPerson(int selectedMenu) {
		if (selectedMenu == 1) {
			System.out.println("새로운 사람을 추가합니다.");
			PersonInfo newPersonInfo = this.inputNewPersonInfo();
			this.contactBook.addNewPersonInfo(newPersonInfo);
		}
	}
	
	private PersonInfo inputNewPersonInfo() {
		System.out.print("이름을 입력하세요.");
		String name = this.keyboard.nextLine();
		
		System.out.print("나이를 입력하세요.");
		int age = this.keyboard.nextInt();
		this.keyboard.nextLine();
		
		System.out.print("생일을 입력하세요.");
		String birthDate = this.keyboard.nextLine();
		
		System.out.print("별명을 입력하세요.");
		String nickname = this.keyboard.nextLine();
		
		System.out.print("연락처를 입력하세요.");
		String contact = this.keyboard.nextLine();
		
		System.out.print("이메일을 입력하세요.");
		String email = this.keyboard.nextLine();
		
		System.out.print("주소(시/군/구)를 입력하세요.");
		String city = this.keyboard.nextLine();
		
		System.out.print("주소(읍/면/동)를 입력하세요.");
		String state = this.keyboard.nextLine();
		
		System.out.print("주소(도로명주소)를 입력하세요.");
		String streetAddress = this.keyboard.nextLine();
		
		System.out.print("주소(지번주소)를 입력하세요.");
		String buildingNumbers = this.keyboard.nextLine();
		
		System.out.print("주소(상세주소)를 입력하세요.");
		String detailAddress = this.keyboard.nextLine();
		
		System.out.print("주소(우편번호)를 입력하세요.");
		String postalCode = this.keyboard.nextLine();
		
		Address address = new Address(city, state, streetAddress, 
				buildingNumbers, detailAddress, postalCode);
		PersonInfo newPersonInfo = new PersonInfo(name, age, LocalDate.parse(birthDate), 
				address, nickname, contact, email);
		
		return newPersonInfo;
	}
	
	public void searchOnePerson(int selectedMenu) {
		if (selectedMenu == 7) {
			System.out.println("조회하려는 인덱스를 입력하세요.");
			int index = this.keyboard.nextInt();
			this.keyboard.nextLine();
			
			boolean wasPrint = this.contactBook.printSearchByIndex(index);
			if (wasPrint) {
				System.out.print("한 사람 정보를 삭제하려면 1");
				System.out.print(" 수정하려면 2");
				System.out.println(" 아무것도 안하려면 9를 입력하세요.");
				
				int nextStep = this.keyboard.nextInt();
				this.keyboard.nextLine();
				
				if (nextStep == 1) {
					this.contactBook.deleteOnePersonInfoByIndex(index);
				}
				else if (nextStep == 2) {
					PersonInfo newPersonInfo = this.inputNewPersonInfo();
					this.contactBook.modifyOnePersonInfoByIndex(index, newPersonInfo);
				}
			}
		}
	}
	
	public static void run() {
		Main main = new Main();
		
		while (true) {
			int selectedMenu = main.printAndSelectMenu();
			if (selectedMenu == 9) {
				break;
			}
			
			main.search(selectedMenu);
			main.addNewPerson(selectedMenu);
			main.searchOnePerson(selectedMenu);
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	public static void main(String[] args) {
		run();
	}
	
}



