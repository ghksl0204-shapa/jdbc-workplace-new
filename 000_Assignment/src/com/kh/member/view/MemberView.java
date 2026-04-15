package com.kh.member.view;

import java.util.Scanner;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("회원 관리 서비스");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보보기");
			System.out.println("3. 회원수정");
			System.out.println("4. 회원삭제");
			System.out.print("메뉴 선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 : insertMember(); break;
			case 2 : break;	
			case 3 : break;	
			case 4 : break;	
			case 0 : return;
			default : System.out.println("잘못입력");
			}
		}
	}

	private void insertMember() {
		System.out.println();
		System.out.println("회원가입서비스");
		System.out.print("아이디를 입력하세요 > ");
		String memberId = sc.nextLine();
		
	}
	
}
