package com.ktdsuniversity.edu.contacts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Address address1 = new Address("서울", "도봉구", "봉활로", "84번지", "둘리네", "1984-1988");
		PersonInfo personInfo1 = new PersonInfo("둘리", 8, LocalDate.of(1993, 8, 2), address1, "도마뱀", "010-8641-6841", "dooli@yoribogo.com", LocalDate.now(), LocalDate.now());
		int option = 0;
		List<PersonInfo> personInfoList = new ArrayList<>();
		personInfoList.add(personInfo1);
		Scanner keyboard = new Scanner(System.in);
		ContactBook contactBook = new ContactBook(personInfoList);
		
		while (true) {
			System.out.println("메뉴 목록");
			System.out.println("1. 이름 혹은 별명 검색");
			System.out.println("2. 연락처 검색");
			System.out.println("3. 보름 이내에 생일을 맞이하는 사람 검색");
			System.out.println("4. 보름 전에 생일을 맞이한 사람 검색");
			System.out.println("5. 주소 검색");
			System.out.println("6. 등록");
			System.out.println("7. 한 사람 조회");
			System.out.println("8. 삭제");
			System.out.println("9. 수정");
			System.out.println("0. 종료");
			
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if(option == 1) {
				System.out.println("검색하실 이름 혹은 별명을 입력하시오");
				String input = keyboard.nextLine();
				contactBook.searchNameNickname(input);
			}else if(option == 2) {
				System.out.println("검색하실 연락처를 입력해주세요");
				String input = keyboard.nextLine();
				contactBook.searchNumber(input);
			}else if(option == 3) {
				contactBook.searchUpcomingBirthday();
			}else if(option == 4) {
				contactBook.searchWasBirthday();
			}else if(option == 5) {
				System.out.println("검색하실 주소를 입력하세요");
				String input = keyboard.nextLine();
				contactBook.searchAddress(input);
			}else if(option == 6) {
				System.out.println("등록할 사람의 정보를 입력해주세요");
				System.out.println("이름을 입력해주세요");
				String name = keyboard.nextLine();
				
				System.out.println("나이를 입력해주세요");
				int age = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.println("생일을 입력해주세요 (YYYY-MM-DD)");
				LocalDate birthday = LocalDate.parse(keyboard.nextLine());
				
				System.out.println("주소를 입력해주세요");
				System.out.println("시/군/구");
				String city = keyboard.nextLine();
				System.out.println("읍/면/동");
				String district = keyboard.nextLine();
				System.out.println("도로명");
				String street = keyboard.nextLine();
				System.out.println("번지(구주소)");
				String previousStreet = keyboard.nextLine();
				System.out.println("상세주소");
				String detail = keyboard.nextLine();
				System.out.println("우편번호");
				String postalCode = keyboard.nextLine();
				Address address = new Address(city, district, street, previousStreet, detail, postalCode);
				
				System.out.println("별명을 입력하세요");
				String nickname = keyboard.nextLine();
				System.out.println("연락처를 입력하세요 (000-0000-0000)");
				String number = keyboard.nextLine();
				System.out.println("이메일을 입력하세요");
				String email = keyboard.nextLine();
				LocalDate now = LocalDate.now();
				PersonInfo newPersonInfo = new PersonInfo(name, age, birthday, address, nickname, number, email, now, now);
				contactBook.addPersonInfo(newPersonInfo);
			}else if(option == 7) {
				System.out.println("조회할 사람의 인덱스를 입력해주세요");
				int index = keyboard.nextInt();
				contactBook.checkPersonInfo(index);
			}else if(option == 8) {
				System.out.println("삭제할 사람의 인덱스를 입력해주세요");
				int index = keyboard.nextInt();
				contactBook.deletePersonInfo(index);
			}else if(option == 9) {
				System.out.println("수정할 사람의 인덱스를 입력해주세요");
				int index = keyboard.nextInt();
				keyboard.nextLine();
				if (index >=0 && index < personInfoList.size()) {
					System.out.println("수정할 정보를 입력해주세요");
					System.out.println("이름을 입력해주세요");
					String name = keyboard.nextLine();
					
					System.out.println("나이를 입력해주세요");
					int age = keyboard.nextInt();
					keyboard.nextLine();
					
					System.out.println("생일을 입력해주세요 (YYYY-MM-DD)");
					LocalDate birthday = LocalDate.parse(keyboard.nextLine());
					
					System.out.println("주소를 입력해주세요");
					System.out.println("시/군/구");
					String city = keyboard.nextLine();
					System.out.println("읍/면/동");
					String district = keyboard.nextLine();
					System.out.println("도로명");
					String street = keyboard.nextLine();
					System.out.println("번지(구주소)");
					String previousStreet = keyboard.nextLine();
					System.out.println("상세주소");
					String detail = keyboard.nextLine();
					System.out.println("우편번호");
					String postalCode = keyboard.nextLine();
					Address address = new Address(city, district, street, previousStreet, detail, postalCode);
					
					System.out.println("별명을 입력하세요");
					String nickname = keyboard.nextLine();
					System.out.println("연락처를 입력하세요 (000-0000-0000");
					String number = keyboard.nextLine();
					System.out.println("이메일을 입력하세요");
					String email = keyboard.nextLine();
					LocalDate now = LocalDate.now();
					PersonInfo newPersonInfo = new PersonInfo(name, age, birthday, address, nickname, number, email, now, now);
					contactBook.editPersonInfo(index, newPersonInfo);	
				}else {
					System.out.println("등록된 정보가 없습니다");
				}
			}else if(option == 0) {
				System.out.println("시스템 종료");
				break;
			}else {
				System.out.println("잘못된 입력입니다");
			}
		}
	}
}
