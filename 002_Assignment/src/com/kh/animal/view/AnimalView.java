package com.kh.animal.view;

import java.util.List;
import java.util.Scanner;

import com.kh.animal.controller.AnimalController;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalView {

	private Scanner sc = new Scanner(System.in);
	private AnimalController ac = new AnimalController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("동물 관리 프로그램");
			System.out.println("1. 동물 추가하기");
			System.out.println("2. 동물 전체조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "0" : sc.close(); return;
			default : System.out.println("잘못된 메뉴 선택"); continue;
			}
		}
	}
	
	private void save() {
		System.out.println();
		System.out.println("동물 추가하기");
		System.out.print("추가할 동물의 이름을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("추가할 동물의 종 번호를 입력해주세요 > ");
		String speciesId = sc.nextLine();
		System.out.print("추가할 동물의 구역 번호를 입력해주세요 > ");
		String zoneId = sc.nextLine();
		System.out.print("추가할 동물의 사육사 번호를 입력해주세요 > ");
		String keeperId = sc.nextLine();
		System.out.print("추가할 동물의 성별을 입력해주세요(M/F) > ");
		String gender = sc.nextLine();
		System.out.print("추가할 동물의 무게를 입력해주세요 > ");
		double weightKg = sc.nextDouble();
		
		int result = ac.save(new AnimalDto(name, speciesId, zoneId, keeperId, gender, weightKg));
		if(result > 0) {
			System.out.println("추가성공");
		} else {
			System.out.println("추가실패");
		}
	}
	
	private void findAll() {
		System.out.println();
		System.out.println("동물 전체조회");
		
		List<AnimalDto> animals = ac.findAll();
		if(animals.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(AnimalDto a : animals) {
				System.out.println("==============================================");
				System.out.println("동물 번호 : " + a.getAnimalId());
				System.out.println("동물 이름 : " + a.getAnimalName());
				System.out.println("종 이름 : " + a.getSpeciesId());
				System.out.println("구역 이름 : " + a.getZoneId());
				System.out.println("사육사 이름 : " + a.getKeeperId());
				System.out.println("성별 : " + a.getGender());
				System.out.println("체중 : " + a.getWeightKg());
				System.out.println("생일 : " + a.getBirthDate());
				System.out.println("도착일 : " + a.getArrivalDate());
				System.out.println("==============================================");
			}
		}
	}
}
