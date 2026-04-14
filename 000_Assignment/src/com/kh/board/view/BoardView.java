package com.kh.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.board.model.dto.BoardDto;

public class BoardView {

	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("게시판 관리 프로그램");
			System.out.println("1. 게시판 추가");
			System.out.println("2. 게시판 전체목록확인");
			System.out.println("3. 게시판 수정");
			System.out.println("4. 게시판 삭제");
			System.out.print("메뉴선택 > ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : insertBoard(); break;
			case "2" : selectBoard(); break;
			case "3" : updateBoard(); break;
			case "4" : break;
			case "0" : break;
			default : System.out.println("잘못된 메뉴 선택"); continue;
			}
		}
	}

	private void insertBoard() {
		
		System.out.println();
		System.out.println("게시판 추가메뉴");
		System.out.print("추가하실 게시판의 카테고리를 입력해주세요 > ");
		String category = sc.nextLine();
		System.out.print("추가하실 게시판의 이름을 입력해주세요 > ");
		String name = sc.nextLine();
		
		int result = new BoardController().insertBoard(new BoardDto(category, name));
		if(result > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	private void selectBoard() {
		
		System.out.println();
		System.out.println("게시판 전체목록확인");
		List<BoardDto> boards = new BoardController().selectBoard();
		if(boards.isEmpty()) {
			System.out.println("목록이 없습니다.");
		} else {
			for(BoardDto b : boards) {
				System.out.println("===============================================================================");
				System.out.println("게시판 NO : " + b.getBoardNo() + ", 카테고리 : " + b.getCategory() + ", 게시판 이름 : " + b.getBoardName());
				System.out.println("===============================================================================");
			}
		}
	}
	
	private void updateBoard() {
		
		System.out.println();
		System.out.println("게시판 수정메뉴");
		System.out.print("수정하실 게시판 번호를 입력해주세요 > ");
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력해주세요."); sc.nextLine(); return;
		}
		System.out.print("수정하실 카테고리를 입력해주세요 > ");
		String category = sc.nextLine();
		System.out.print("수정하실 게시판 이름을 입력해주세요 > ");
		String name = sc.nextLine();
		
		int result = new BoardController().updateBoard(new BoardDto(boardNo, category, name));
		
		if (result > 0) {
			System.out.println("수정성공");
		} else {
			System.out.println("수정실패");
		}
	}
}
