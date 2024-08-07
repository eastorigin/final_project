package com.ktdsuniversity.edu.contacts.answer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactBook {

	private List<PersonInfo> contacts;
	
	public ContactBook() {
		this.contacts = new ArrayList<>();
		read();
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
			
			// || && 동시사용. && 우선순위 먼저 가져감
			
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
		
		save();
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
			
			save();
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
			
			save();
		}
		else {
			System.out.println("수정이 취소되었습니다.");
		}
	}
	
	public void save() {
		// 주소록을 등록/수정/삭제할 때마다 호출
		// 사람 정보들 인스턴스의 정보를 파일에 쓰기
		
		// 파일에 쓸 내용
		List<String> fileLines = new ArrayList<>();
		
		// 사람 정보들의 내용들을 fileLines로 옮겨주기
		for (PersonInfo personInfo : this.contacts) {
			// 파일에 쓸 형식
			// 이름|나이|생일|주소(시군구)|주소(읍면동)|주소(도로명)|주소(지번)|주소(상세)|주소(우편번호)|별명|연락처|이메일|생성일|마지막 수정일
			String format = "%s|%d|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s";
			String line = String.format(format, personInfo.getName(), personInfo.getAge(), personInfo.getBirthDate(), personInfo.getAddress().getCity(),
					personInfo.getAddress().getState(), personInfo.getAddress().getStreetAddress(), personInfo.getAddress().getBuildingNumbers(),
					personInfo.getAddress().getDetailAddress(), personInfo.getAddress().getPostalCode(), personInfo.getNickname(), personInfo.getContact(),
					personInfo.getEmail(), personInfo.getCreateDate(), personInfo.getLastestModifyDate());
			
			fileLines.add(line);
		}
		
		File file = new File("C:\\contacts", "contacts.txt");
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		try {
			Files.write(file.toPath(), fileLines);			
		}catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("저장할 수 없습니다");
		}
	}
	
	public void read() {
		// 주소록 인스턴스가 만들어질 때 호출
		// 파일을 읽어서 사람 정보를 인스턴스에 사람 정보를 할당
		
		File file = new File("C:\\contacts", "contacts.txt");
		
		// 1. contacts 폴더가 있는가?
			// 없으면 어떻게? - 아무것도 하지말자
		if (!file.getParentFile().exists()) {
			return;
		}
		
		
		// 2. contacts.txt 파일이 있는가?
			// 없으면 어떻게? - 아무것도 하지말자
		if (!file.exists()) {
			return;
		}
		
		// 3. contacts.txt 파일의 내용을 어떻게 List (사람 정보들)에 넣을 것인가?
			// 한 줄 한 줄 읽어서 파이프(|)로 자른 다음 인덱스를 하나씩 읽어서 인스턴스로 만들자
		List<String> fileLines = null;
		try {
			fileLines = Files.readAllLines(file.toPath());			
		}catch (IOException ioe) {
			// 파일을 읽다가 에러가 발생한 상황
			// 발생의 원인
				// 1. 폴더가 없다
				// 2. 파일이 없다
				// 3. 다른 응용프로그램이 파일을 사용 중이다 (Lock)
			System.out.println(ioe.getMessage());
			return;
		}
		//	0	1  2	3		4			5		6		7		8		9  10   11   12		13
		// 이름|나이|생일|주소(시군구)|주소(읍면동)|주소(도로명)|주소(지번)|주소(상세)|주소(우편번호)|별명|연락처|이메일|생성일|마지막 수정일
		for (String line : fileLines) {
			String[] splittedLine = line.split("\\|");
			
			Address address = new Address (splittedLine[3], splittedLine[4], splittedLine[5], splittedLine[6], splittedLine[7], splittedLine[8]);
			
			PersonInfo personInfo = new PersonInfo (splittedLine[0], Integer.parseInt(splittedLine[1]), LocalDate.parse(splittedLine[2]), address
					,splittedLine[9], splittedLine[10], splittedLine[11]);
			
			// 생성일과 마지막 수정일이 있으면 사람 정보에 할당하기
			// 생성일은 무조건 있음
			personInfo.setCreateDate(LocalDate.parse(splittedLine[12]));
			
			// 마지막 수정일은 잘 모름
			if (splittedLine.length -1 == 13 && splittedLine[13] != null && !splittedLine[13].equals("")) {
				personInfo.setLatestModifyDate(LocalDate.parse(splittedLine[13]));
			}
			
			this.contacts.add(personInfo);
		}
	}
	
}
