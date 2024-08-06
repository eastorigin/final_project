package com.ktdsuniversity.edu.contacts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Address address1 = new Address("서울", "도봉구", "봉활로", "84번지", "둘리네", "1984-1988");
		PersonInfo personInfo1 = new PersonInfo("둘리", 8, LocalDate.of(1993, 8, 7), address1, "도마뱀", "010-8641-6841", "dooli@yoribogo.com", LocalDate.now(), LocalDate.now());
		int number = 0;
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
			
			number = keyboard.nextInt();
			keyboard.nextLine();
			
			if(number == 1) {
				System.out.println("검색하실 이름 혹은 별명을 입력하시오");
				String input = keyboard.nextLine();
				contactBook.searchNameNickname(input);
			}else if(number == 2) {
				System.out.println("검색하실 연락처를 입력해주세요");
				String input = keyboard.nextLine();
				contactBook.searchNumber(input);
			}else if(number == 3) {
				contactBook.searchUpcomingBirthday();
			}else if(number == 0) {
				System.out.println("시스템 종료");
				break;
			}
		}
	}
}
